package conexion;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Contexto implements AutoCloseable{
	private static ThreadLocal<Contexto> instance = new ThreadLocal<Contexto>();

    private HttpServletRequest request;
    private HttpServletResponse response;

    private Contexto(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public static Contexto create(HttpServletRequest request, HttpServletResponse response) {
        Contexto context = new Contexto(request, response);
        instance.set(context);
        return context;
    }

    public static Contexto getCurrentInstance() {
        return instance.get();
    }

    @Override    
    public void close() {
        instance.remove();
    }

    //... (add methods here which return/delegate the request/response).    
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        response = (HttpServletResponse) res;

        try (Contexto contexto = Contexto.create(request, response)) {
            chain.doFilter(request, response);
        }
    }
}

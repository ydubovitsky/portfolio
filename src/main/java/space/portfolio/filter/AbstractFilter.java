package space.portfolio.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class AbstractFilter implements Filter {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass()); //? Почему не статик?

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        doFilter(req, resp, chain); //! Вызываем абстрактный метод, где используются приведенные типа параметров метода
    }

    //! Поставить точки останова, посмотреть какой метод будет вызываться у наследников
    abstract public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException;

    @Override
    public void destroy() {

    }
}

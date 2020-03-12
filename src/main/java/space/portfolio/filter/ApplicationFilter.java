package space.portfolio.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/")
public class ApplicationFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.debug("ApplicationFilter void init(...)");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.debug("ApplicationFilter void doFilter(...)");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        LOGGER.debug("ApplicationFilter void destroy(...)");
    }
}

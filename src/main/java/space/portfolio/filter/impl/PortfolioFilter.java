package space.portfolio.filter.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import space.portfolio.filter.AbstractFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class PortfolioFilter extends AbstractFilter {

    @Value("${application.production}")
    private boolean production; //? Каким образом считываются настройки?

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        String requestURI = req.getRequestURI();
        req.setAttribute("REQUEST_URI", requestURI);
        try {
            filterChain.doFilter(req, resp); //? Тут же дальше по цепочке фильтров передается управление, какие могут быть тут ошибки?
        } catch (Throwable throwable) {
            LOGGER.error("Failed : " + throwable.getMessage(), throwable);
            handleException(throwable, requestURI, resp);
        }
    }

    private void handleException(Throwable throwable, String requestURI, HttpServletResponse resp) throws IOException, ServletException {
        if (production) {
            if ("/error".equals(requestURI)) { //! Если в результате отображения url /error произошла ошибка и чтобы не было циклического зависания, мы выбрасываем throw new ServletException(throwable);
                throw new ServletException(throwable);
            } else {
                resp.sendRedirect("/error?url=" + requestURI);
            }
        } else { //* Если не продакшн
            throw new ServletException(throwable);
        }
    }
}

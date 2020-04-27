package space.dubovitsky.portfolio.filter.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import space.dubovitsky.portfolio.filter.AbstractFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class PortfolioFilter extends AbstractFilter {

	@Value("${application.production}")
	private boolean production;
	
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
		String requestUrl = req.getRequestURI();
		req.setAttribute("REQUEST_URL", requestUrl); //* Запоминаем ссылку, которую запрашивал клиент
		try {
			chain.doFilter(req, resp);
		} catch (Throwable th) {
			LOGGER.error("Process request failed: " + requestUrl, th);
			handleException(th, requestUrl, resp);
		}
	}
	
	private void handleException(Throwable th, String requestUrl, HttpServletResponse resp) throws ServletException, IOException {
		if(production) {
			if ("/error".equals(requestUrl)) {
				throw new ServletException(th);
			} else {
				resp.sendRedirect("/error?url="+requestUrl);
			}
		} else {
			throw new ServletException(th);
		}
	}
}

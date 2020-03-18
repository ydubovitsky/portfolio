package space.portfolio.configuration;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import space.portfolio.filter.impl.PortfolioFilter;
import space.portfolio.listener.ApplicationListener;

import javax.servlet.*;
import java.util.EnumSet;

public class PortfolioWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		WebApplicationContext ctx = createWebApplicationContext(container);

		container.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));
		container.addListener(new ContextLoaderListener(ctx));
		container.addListener(ctx.getBean(ApplicationListener.class));

		registerFilters(container, ctx);
		registerSpringMVCDispatcherServlet(container, ctx);
	}

    /**
     * Создаем контекст?
     * @param container - ?
     * @return
     */
	private WebApplicationContext createWebApplicationContext(ServletContext container) {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.scan("space.portfolio.configuration"); //! Сканируем пакет с конфигурацией и добавляем в Spring IOC контейнер
		ctx.setServletContext(container); //? в контекст сетается контейнер?
		ctx.refresh();
		return ctx;
	}

	/**
	 * Регистрируем фильтры
	 * @param container
	 * @param ctx
	 */
	private void registerFilters(ServletContext container, WebApplicationContext ctx) {
		registerFilter(container, ctx.getBean(PortfolioFilter.class)); //! Почему фильтры автоматически не добавляются как контроллеры?
		registerFilter(container, new CharacterEncodingFilter("UTF-8", true));
		registerFilter(container, buildConfigurableSiteMeshFilter(), "sitemesh"); //! Как это работает?
	}

	/**
	 * Добавляем в Spring IOC контейнер фильтры
	 * @param container
	 * @param filter
	 * @param filterNames
	 */
	private void registerFilter(ServletContext container, Filter filter, String... filterNames) { //? Что за 3ий аргуемент, зачем?
		String filterName = filterNames.length > 0 ? filterNames[0] : filter.getClass().getSimpleName();
		container.addFilter(filterName, filter).addMappingForUrlPatterns(null, true, "/*");
	}

	/**
	 * Метод создает фронт-контроллер в модели spring-mvc
	 * В контейнер добавляется DispatcherServlet, устанавливается маппинг и он загружается самым первым
	 */
	private void registerSpringMVCDispatcherServlet(ServletContext container, WebApplicationContext ctx) {
		//? Прочитать про ServletRegistration.Dynamic servletRegistration
		ServletRegistration.Dynamic servletRegistration = container.addServlet("dispatcher", new DispatcherServlet(ctx));
		servletRegistration.setLoadOnStartup(1);
		servletRegistration.addMapping("/");
	}

	private ConfigurableSiteMeshFilter buildConfigurableSiteMeshFilter() { //! Как работает? Для чего
		return new ConfigurableSiteMeshFilter() {
			@Override
			protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
				builder
					.addDecoratorPath("/*", "/WEB-INF/template/page-template.jsp");
			}
		};
	}
}

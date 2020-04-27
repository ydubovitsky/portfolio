package space.dubovitsky.portfolio;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import space.dubovitsky.portfolio.filter.impl.PortfolioFilter;
import space.dubovitsky.portfolio.listener.ApplicationListener;

import javax.servlet.*;
import java.util.EnumSet;

//? Что такое контейнер - это классы + метаданные. А контейнер отвечает за создание объектов (бинов) и их жизненный цикл и т.д.
public class PortfolioWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException { //! servletContext - это контекст всего веб приложения, т.е. грубо говоря, контейнер, в котором находятся все компоненты, включая Spring
		WebApplicationContext ctx = createWebApplicationContext(servletContext); //* Создаем конфигурацию Спринг контейнера

		servletContext.setSessionTrackingModes(EnumSet.of(SessionTrackingMode.COOKIE));
		servletContext.addListener(new ContextLoaderListener(ctx));
		servletContext.addListener(ctx.getBean(ApplicationListener.class));

		registerFilters(servletContext, ctx);
		registerDispatcherServlet(servletContext, ctx);
	}

	private WebApplicationContext createWebApplicationContext(ServletContext servletContext) {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext(); //* Конфигурируем контейнер на основе аннотаций
		ctx.scan("space.dubovitsky.portfolio.configuration");
		ctx.setServletContext(servletContext); //? Добавляем в контейнер Спринг серлвет контекст, так понимаю для того чтобы из Спринга была возможность обращаться к веб контейнеру (TOMCAT)
		ctx.refresh();
		return ctx;
	}

	private void registerFilters(ServletContext container, WebApplicationContext ctx) {
		registerFilter(container, ctx.getBean(PortfolioFilter.class));
		registerFilter(container, new CharacterEncodingFilter("UTF-8", true)); //* Это спринг фильтр, который отвечает за кодировку
		registerFilter(container, buildConfigurableSiteMeshFilter(), "sitemesh");
	}

	private void registerFilter(ServletContext servletContext, Filter filter, String... filterNames) { //! А добавляем фильтры мы в ServletContext фильтры, так как Spring фильтры не работают на jsp (как я понимаю), обработчики ошибок уже точно не работают
		String filterName = filterNames.length > 0 ? filterNames[0] : filter.getClass().getSimpleName(); //* Если передается сам фильтр и его название, как с sitemesh
		servletContext.addFilter(filterName, filter).addMappingForUrlPatterns(null, true, "/*");
	}

	/**
	 * Добавляем в контейнер серевлетов(TOMCAT) Диспатчер сервлет.
	 */
	private void registerDispatcherServlet(ServletContext servletContext, WebApplicationContext ctx) {
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

	private ConfigurableSiteMeshFilter buildConfigurableSiteMeshFilter() {
		return new ConfigurableSiteMeshFilter() {
			@Override
			protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
				builder
					.addDecoratorPath("/*", "/WEB-INF/template/page-template.jsp");
			}
		};
	}
}

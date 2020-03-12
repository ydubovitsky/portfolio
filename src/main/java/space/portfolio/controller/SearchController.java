package space.portfolio.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import space.portfolio.service.NameService;

@WebServlet("/search")
public class SearchController extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("doGet Search");
        req.getRequestDispatcher("/WEB-INF/jsp/search-form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.debug("doPost search: {} ", req.getParameterMap());
        String name = req.getParameter("name");
        if (!isValid(name)) {
            req.setAttribute("invalid", Boolean.TRUE);
            req.getRequestDispatcher("/WEB-INF/jsp/search-form.jsp").forward(req, resp);
            return;
        }
        String result = NameService.getInstance().convertName(name);
        req.setAttribute("result", result);
        req.getRequestDispatcher("/WEB-INF/jsp/search-result.jsp").forward(req, resp);
    }

    private boolean isValid(String name) {
        return name != null && name.trim().length() != 0;
    }
}

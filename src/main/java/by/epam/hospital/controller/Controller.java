package by.epam.hospital.controller;

import org.apache.log4j.Logger;
import by.epam.hospital.command.Command;
import by.epam.hospital.command.CommandHelper;
import by.epam.hospital.utils.PagesManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    private static final Logger logger = Logger.getLogger(Controller.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Command command = CommandHelper.getInstance().defineCommand(req);
        String page = command.execute(req, resp);

        if (!page.isEmpty()) {
            logger.info("Forward to " + page);
            req.getServletContext().getRequestDispatcher(page).forward(req, resp);
        } else {
            page = PagesManager.getProperty("path.page.error");
            logger.info("Redirect to " + page);
            resp.sendRedirect(req.getContextPath() + page);
        }
    }

}

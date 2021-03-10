package by.epam.hospital.filter;


import by.epam.hospital.entity.Person;
import by.epam.hospital.utils.PagesManager;
import by.epam.hospital.utils.UserUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        String path = request.getRequestURI();
        if (path.indexOf("/image") > 0) {
            filterChain.doFilter(request, response);
            return;
        } else if (path.endsWith(".ico")) {
            filterChain.doFilter(request, response);
            return;
        } else if (path.endsWith(".css")) {
            filterChain.doFilter(request, response);
            return;
        }
        String page;
        if (request.getParameter("command") == null) {
            if (session != null) {
                Person person = (Person) session.getAttribute("user");
                if (person == null) {
                    page = PagesManager.getProperty("path.page.login");
                } else {
                    page = UserUtils.getInstance().getPageByRole(person.getRole().getName().toUpperCase());
                }
                request.getRequestDispatcher(page).forward(request, response);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}

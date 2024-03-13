package org.example.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Model.DTO.CreateUserDTO;
import java.io.IOException;
import java.util.Set;
import static org.example.Model.Utill.PublicURL.*;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    private final static Set<String> PATH = Set.of(LOGIN, REGISTER);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String uri = ((HttpServletRequest) servletRequest).getRequestURI();
        if (isPublicPath(uri) || isUserLogged(servletRequest))
        {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else
        {
            String Preview = ((HttpServletRequest) servletRequest).getHeader("referer");
            ((HttpServletResponse) servletResponse).sendRedirect(Preview != null ? Preview : LOGIN);
        }
    }
    private boolean isUserLogged(ServletRequest servletRequest) {
        CreateUserDTO createUserDTO = (CreateUserDTO) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        return createUserDTO != null;
    }

    private boolean isPublicPath(String uri) {
       return PATH.stream().anyMatch(uri::startsWith);
    }

}

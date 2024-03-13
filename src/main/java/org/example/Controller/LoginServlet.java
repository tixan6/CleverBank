package org.example.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.example.Model.DTO.CreateUserDTO;
import org.example.Model.Entity.Users;
import org.example.Model.Service.UserService;

import java.io.IOException;
import java.util.Optional;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserService userService = UserService.getInstanse();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/View/login.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CreateUserDTO createUserDTO = userService.login(req.getParameter("email"), req.getParameter("password"));
            isLogin(createUserDTO, req, resp);
        }
        catch (Exception e)
        {
            isNotLogin(req, resp);
        }

    }
    @SneakyThrows
    private static void isLogin(CreateUserDTO user, HttpServletRequest req, HttpServletResponse resp)
    {
        req.getSession().setAttribute("user", user);
        resp.sendRedirect("/index");
    }

    @SneakyThrows
    private static void isNotLogin(HttpServletRequest req, HttpServletResponse resp)
    {
        resp.sendRedirect("/login?error");
    }
}

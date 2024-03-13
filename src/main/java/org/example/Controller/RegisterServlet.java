package org.example.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Model.DTO.CreateUserDTO;
import org.example.Model.Entity.Enums.Gender;
import org.example.Model.Service.UserService;
import org.example.Model.Validator.ValidatorException;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final UserService USER_SERVICE = UserService.getInstanse();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           CreateUserDTO createUserDTO = CreateUserDTO.builder()
                   .firstName(req.getParameter("name"))
                   .lastName(req.getParameter("surname"))
                   .patronymic(req.getParameter("patronymic"))
                   .birthday(LocalDate.parse(req.getParameter("birthday")))
                   .age(Integer.valueOf(req.getParameter("age")))
                   .passport(req.getParameter("passport"))
                   .gender(Gender.valueOf(req.getParameter("gender")))
                   .phone(req.getParameter("phone"))
                   .email(req.getParameter("email"))
                   .password(req.getParameter("password"))
                   .build();

           try {
               USER_SERVICE.create(createUserDTO);
               resp.sendRedirect("/login");
           }
           catch (ValidatorException e)
           {
               req.setAttribute("error", e.getStringStringHashMap());
               doGet(req, resp);
           }
       }
       catch (Exception e)
       {
           req.setAttribute("error", "Заполните поля");
           doGet(req, resp);
       }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/View/register.jsp").forward(req, resp);
    }
}

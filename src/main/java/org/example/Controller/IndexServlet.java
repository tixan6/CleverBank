package org.example.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.Model.DTO.AccountDTO;
import org.example.Model.DTO.CreateUserDTO;
import org.example.Model.Entity.Users;
import org.example.Model.Service.AccountService;
import org.example.Model.Service.BanksService;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    BanksService banksService = BanksService.getInstance();
    AccountService accountService = AccountService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        createField(req, req.getSession().getAttribute("user"));
        //Реальный ID
        req.setAttribute("accounts", accountService.findAllByIdAccount(13L));

        req.getRequestDispatcher("WEB-INF/View/index.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (accountService.delete(Long.valueOf(req.getParameter("idAccount"))))
        {
            //Если удалили
        }
        else
        {
            //Не удалили!!!
        }
    }

    private static void createField(HttpServletRequest req, Object object)
    {
        CreateUserDTO createUserDTO = (CreateUserDTO) object;
        req.setAttribute("firstName", createUserDTO.getFirstName());
        req.setAttribute("lastName", createUserDTO.getLastName());
        req.setAttribute("patronymic", createUserDTO.getPatronymic());
        req.setAttribute("age", createUserDTO.getAge());
        req.setAttribute("id", createUserDTO.getId());
        req.setAttribute("email", createUserDTO.getEmail());
        req.setAttribute("passport", createUserDTO.getPassport());
        req.setAttribute("phone", createUserDTO.getPhone());
        req.setAttribute("birthday", createUserDTO.getBirthday());
        req.setAttribute("gender", createUserDTO.getGender());
    }
}

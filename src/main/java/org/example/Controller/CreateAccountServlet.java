package org.example.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Model.DTO.AccountDTO;
import org.example.Model.DTO.BanksDTO;
import org.example.Model.DTO.CreateUserDTO;
import org.example.Model.Entity.Banks;
import org.example.Model.Mapper.BanksMapper;
import org.example.Model.Mapper.UserMapper;
import org.example.Model.Service.AccountService;
import org.example.Model.Service.BanksService;
import org.example.Model.Validator.Validator;
import org.example.Model.Validator.ValidatorException;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/create_account")
public class CreateAccountServlet extends HttpServlet {
    private static AccountService accountService = AccountService.getInstance();
    private static BanksService banksService = BanksService.getInstance();
    private static UserMapper userMapper = UserMapper.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateUserDTO createUserDTO = (CreateUserDTO) req.getSession().getAttribute("user");
        createField(req, req.getSession().getAttribute("user"));
        req.setAttribute("banks", banksService.findAll());
        req.getRequestDispatcher("WEB-INF/View/createAccount.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bank = req.getParameter("banks");

        CreateUserDTO createUserDTO = (CreateUserDTO) req.getSession().getAttribute("user");
        createField(req, req.getSession().getAttribute("user"));

        try {
            AccountDTO accountDTO = accountService.Save(createAccount(createUserDTO, banksService.findBankByName(bank)));
            req.setAttribute("accounts", accountService.findAllByIdAccount(13L));
            req.setAttribute("new_account", ("Счёт в банке " + accountDTO.getBank().getName() + " создан"));
            req.getRequestDispatcher("WEB-INF/View/index.jsp").forward(req, resp);
        }
        catch (ValidatorException e)
        {
            req.setAttribute("errors", e.getStringStringHashMap());
            doGet(req, resp);
        }
    }

    private static AccountDTO createAccount(CreateUserDTO createUserDTO, Banks banks)
    {
        AccountDTO accountDTO = AccountDTO.builder()
                .Bank(banks)
                .User(userMapper.fromTo(createUserDTO))
                .Id(createUserDTO.getId())
                .Date_foundation(LocalDate.now())
                .build();
        return accountDTO;
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

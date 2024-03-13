package org.example.Model.Service;


import org.example.Model.DAO.AccountDAO;
import org.example.Model.DTO.AccountDTO;
import org.example.Model.Validator.Validator;
import org.example.Model.Validator.ValidatorAccountCreater;
import org.example.Model.Validator.ValidatorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountService {
    private static final AccountService INSTANCE = new AccountService();
    private static AccountDAO accountDAO = AccountDAO.getInstance();
    public AccountDTO Save(AccountDTO accountDTO) throws ValidatorException {
            return accountDAO.save(accountDTO);
    }

    public List<AccountDTO> findAllByIdAccount(Long id) {
        List<AccountDTO> accountDTO = new ArrayList<>(accountDAO.findAllByIdAccountUser(id).get());
        return accountDTO;
    }

    public boolean delete(Long id)
    {
        return accountDAO.delete(id);
    }


    public static AccountService getInstance()
    {
        return INSTANCE;
    }

}

package org.example.Model.Service;

import org.example.Model.DAO.BankDAO;
import org.example.Model.DTO.BanksDTO;
import org.example.Model.Entity.Banks;
import org.example.Model.Mapper.BanksMapper;
import org.example.Model.Validator.Validator;
import org.example.Model.Validator.ValidatorAccountCreater;
import org.example.Model.Validator.ValidatorException;

import java.util.List;
public class BanksService {
    private static BanksService INSTANCE = new BanksService();
    private BankDAO bankDAO = BankDAO.getInstance();
    private BanksMapper banksMapper = BanksMapper.getInstance();
    private static Validator validator = Validator.getInstance();
    private static ValidatorAccountCreater validatorAccountCreater = ValidatorAccountCreater.getInstance();

    public List<BanksDTO> findAll()
    {
        return banksMapper.fromTo(bankDAO.findAll());
    }

    public Banks findBankByName(String name) throws ValidatorException
    {
        if (!validatorAccountCreater.isValid(name).isEmpty())
        {
            throw new ValidatorException(validator.getError());
        }
        return bankDAO.findByName(name);
    }

    public static BanksService getInstance()
    {
        return INSTANCE;
    }
}

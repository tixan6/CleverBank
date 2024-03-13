package org.example.Model.Validator;

import org.example.Model.DTO.CreateUserDTO;

import java.util.HashMap;

public class ValidatorRegister {

    public static Validator validator = Validator.getInstance();
    private static ValidatorRegister INSTANCE = new ValidatorRegister();
    public HashMap isValid(CreateUserDTO createUserDTO)
    {
        if (!ValidatorUtillRegister.checkFio(createUserDTO.getFirstName()))
        {
            validator.setError("Ошибка ввода имени", "имя введено не верно");
        }
        if (!ValidatorUtillRegister.checkFio(createUserDTO.getLastName()))
        {
            validator.setError("Ошибка ввода фамилии", "фамилия введена не верно");
        }
        if (!ValidatorUtillRegister.checkFio(createUserDTO.getFirstName()))
        {
            validator.setError("Ошибка ввода отчества", "отчество введено не верно");
        }
        if (!ValidatorUtillRegister.checkAge(createUserDTO.getAge()))
        {
            validator.setError("Ошибка ввода возраста", "возраст введен не верно");
        }
        if (!ValidatorUtillRegister.checkPHONE(createUserDTO.getPhone()))
        {
            validator.setError("Ошибка ввода номера телефона", "номер телефона введен не верно");
        }
        if (!ValidatorUtillRegister.checkPassport(createUserDTO.getPassport()))
        {
            validator.setError("Ошибка ввода паспорта", "паспорт введен не верно");
        }
        if (!ValidatorUtillRegister.checkEmail(createUserDTO.getEmail()))
        {
            validator.setError("Ошибка ввода почты", "почта введена не верно");
        }
        if (!ValidatorUtillRegister.checkPassword(createUserDTO.getPassword()))
        {
            validator.setError("Ошибка ввода пароля", "слабый пароль");
        }
        return validator.getError();
    }


    public static ValidatorRegister getInstance()
    {
        return INSTANCE;
    }
}

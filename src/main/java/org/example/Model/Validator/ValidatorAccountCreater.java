package org.example.Model.Validator;

import java.util.HashMap;

public class ValidatorAccountCreater
{
    private static final ValidatorAccountCreater INSTANCE = new ValidatorAccountCreater();
    private static final Validator validator = Validator.getInstance();


    public HashMap isValid(String name)
    {
        if (ValidatorUtillAccountCreater.checkBankChoice(name))
        {
            validator.setError("Ошибка выбора банка", "Выберите банк");
            return validator.getError();
        }
        validator.clear();
        return validator.getError();
    }


    public static ValidatorAccountCreater getInstance()
    {
        return INSTANCE;
    }
}

package org.example.Model.Service;


import lombok.NoArgsConstructor;

import org.example.Model.DAO.userDAO;
import org.example.Model.DTO.CreateUserDTO;
import org.example.Model.Entity.Users;
import org.example.Model.Mapper.LoginMapper;
import org.example.Model.Mapper.RegisterUserMapper;
import org.example.Model.Validator.Validator;
import org.example.Model.Validator.ValidatorException;
import org.example.Model.Validator.ValidatorRegister;

import javax.swing.text.html.Option;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserService {
    public static final UserService INSTANCE = new UserService();
    private final RegisterUserMapper userMapper = RegisterUserMapper.getInstance();
    private final LoginMapper loginUserMapper = LoginMapper.getINSTANCE();
    private final ValidatorRegister validatorRegister = ValidatorRegister.getInstance();
    private final Validator validator = Validator.getInstance();
    private final userDAO user = userDAO.getInstance();

    public Long create(CreateUserDTO createUserDTO) throws ValidatorException {
        if (!validatorRegister.isValid(createUserDTO).isEmpty())
        {
            throw new ValidatorException(validator.getError());
        }
        user.save(userMapper.fromTo(createUserDTO));
        return createUserDTO.getId();
    }

    public CreateUserDTO login(String email, String password) throws Exception
    {
        Optional<Users> users = user.findByEmailAndPassword(email, password);
        return loginUserMapper.fromTo(users.get());
    }

    public static UserService getInstanse()
    {
        return INSTANCE;
    }




}

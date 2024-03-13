package org.example.Model.Mapper;

import org.example.Model.DTO.CreateUserDTO;
import org.example.Model.Entity.Users;

public class RegisterUserMapper implements Mapper<CreateUserDTO, Users>{

    private static final RegisterUserMapper registerUserMapper = new RegisterUserMapper();
    public static RegisterUserMapper getInstance()
    {
        return registerUserMapper;
    }
    @Override
    public Users fromTo(CreateUserDTO object) {
        return Users.builder()
                .firstName(object.getFirstName())
                .lastName(object.getLastName())
                .patronymic(object.getPatronymic())
                .birthday(object.getBirthday())
                .age(object.getAge())
                .passport(object.getPassport())
                .gender(object.getGender())
                .email(object.getEmail())
                .phone(object.getPhone())
                .password(object.getPassword())
                .build();
    }
}

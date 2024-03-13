package org.example.Model.Mapper;

import org.example.Model.DTO.CreateUserDTO;
import org.example.Model.Entity.Users;

public class UserMapper implements Mapper<CreateUserDTO, Users>{

    private static final UserMapper INSTANCE = new UserMapper();

    @Override
    public Users fromTo(CreateUserDTO object) {
        Users users = Users.builder()
                .id(object.getId())
                .firstName(object.getFirstName())
                .lastName(object.getLastName())
                .patronymic(object.getPatronymic())
                .gender(object.getGender())
                .phone(object.getPhone())
                .passport(object.getPassport())
                .age(object.getAge())
                .birthday(object.getBirthday())
                .email(object.getEmail())
                .build();
        return users;
    }


    public static UserMapper getInstance()
    {
        return INSTANCE;
    }
}

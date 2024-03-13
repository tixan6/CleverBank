package org.example.Model.Mapper;

import org.example.Model.DTO.CreateUserDTO;
import org.example.Model.Entity.Users;

public class LoginMapper implements Mapper<Users, CreateUserDTO>{
    private static LoginMapper INSTANCE = new LoginMapper();
    @Override
    public CreateUserDTO fromTo(Users object) {
        return CreateUserDTO.builder()
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
    }
    public static LoginMapper getINSTANCE() {
        return INSTANCE;
    }

}

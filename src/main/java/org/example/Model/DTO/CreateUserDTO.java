package org.example.Model.DTO;


import lombok.Builder;
import lombok.Value;
import org.example.Model.Entity.Enums.Gender;

import java.time.LocalDate;

@Value
@Builder

public class CreateUserDTO {
    Long id;
    String firstName;
    String lastName;
    String patronymic;
    LocalDate birthday;
    Integer age;
    String passport;
    String email;
    String phone;
    String password;
    Gender gender;
}

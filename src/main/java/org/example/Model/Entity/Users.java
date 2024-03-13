package org.example.Model.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Model.Entity.Enums.Gender;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate birthday;
    private Integer age;
    private String passport;
    private String email;
    private String phone;
    private Gender gender;
    private String password;

}

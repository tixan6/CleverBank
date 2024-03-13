package org.example.Model.DTO;

import lombok.Builder;
import lombok.Data;
import org.example.Model.Entity.Banks;
import org.example.Model.Entity.Users;

import java.math.BigDecimal;
import java.time.LocalDate;


@Builder
@Data
public class AccountDTO {
    private Long Id;
    private Users User;
    private Banks Bank;
    private LocalDate Date_foundation;
    private BigDecimal balance;
}

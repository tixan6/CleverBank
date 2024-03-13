package org.example.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long Id;
    private Users User;
    private Banks Bank;
    private LocalDate Date_foundation;
    private BigDecimal balance;
}

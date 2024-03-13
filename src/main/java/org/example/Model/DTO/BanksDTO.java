package org.example.Model.DTO;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.Date;

@Value
@Builder
public class BanksDTO {
    Integer id;
    String name;
    LocalDate date;
}

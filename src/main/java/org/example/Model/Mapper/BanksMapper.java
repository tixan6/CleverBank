package org.example.Model.Mapper;

import org.example.Model.DTO.BanksDTO;
import org.example.Model.Entity.Banks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BanksMapper implements Mapper<Banks, BanksDTO> {
    private static BanksMapper INSTANCE = new BanksMapper();
    public List<BanksDTO> fromTo(Optional<List<Banks>> list)
    {
        List<BanksDTO> ListbanksDTO = new ArrayList<>();
        for (var item : list.get()) {
            ListbanksDTO.add(
                    BanksDTO.builder()
                            .id(item.getId())
                            .name(item.getName())
                            .date(item.getDate())
                            .build()
            );
        }
        return ListbanksDTO;
    }

    public Banks fromTo(BanksDTO banksDTO)
    {
        Banks banks = null;
        banks = Banks.builder()
                .id(banksDTO.getId())
                .name(banksDTO.getName())
                .date(banksDTO.getDate())
                .build();
        return banks;
    }

    @Override
    public BanksDTO fromTo(Banks object) {
        return null;
    }
    public static BanksMapper getInstance() {
        return INSTANCE;
    }
}

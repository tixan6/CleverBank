package org.example.Model.DAO;

import org.example.Model.Connection.ConnectionManager;
import org.example.Model.Entity.Banks;
import org.example.Model.Utill.DateFormatter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class BankDAO implements DAO<Integer, Banks>{
    private final static BankDAO INSTANCE = new BankDAO();
    private static String SQLFindAll = """
                SELECT id, name, dateoffoundation FROM bank;
            """;
    private static String SQLFindByName = """
                SELECT id, name, dateoffoundation FROM bank WHERE name = ?;
            """;
    @Override
    public Optional<List<Banks>> findAll() {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQLFindAll)) {

            List<Banks> ListBanks = new ArrayList<>();
            Banks banks = null;
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                banks = Banks.builder()
                        .id(resultSet.getObject("id", Integer.class))
                        .name(resultSet.getObject("name", String.class))
                        .date(resultSet.getObject("dateoffoundation", LocalDate.class))
                        .build();
                ListBanks.add(banks);
            }

            return Optional.ofNullable(ListBanks);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }

    public Banks findByName(String name)
    {
        try (Connection connection = ConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQLFindByName)) {
            Banks bank = null;
            preparedStatement.setObject(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                bank = Banks.builder()
                        .id(resultSet.getObject("id", Integer.class))
                        .name(resultSet.getString("name"))
                        .date(resultSet.getObject("dateoffoundation", LocalDate.class))
                        .build();
            }

            return bank;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Banks findById(Integer id) {
        return null;
    }


    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Banks save(Banks entity) {
        return null;
    }

    @Override
    public boolean update(Banks entity) {
        return false;
    }

    public static BankDAO getInstance()
    {
        return new BankDAO();
    }

}

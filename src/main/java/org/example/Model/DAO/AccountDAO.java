package org.example.Model.DAO;

import org.example.Model.Connection.ConnectionManager;
import org.example.Model.DTO.AccountDTO;
import org.example.Model.Entity.Banks;
import org.example.Model.Entity.Users;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDAO implements DAO<Long, AccountDTO>{
    private final static AccountDAO accountDTO = new AccountDAO();
    private static String SQL_SAVE = """
            INSERT INTO account (id_user, id_bank, date_foundation, balance)
            VALUES
            (?, ?, ?, ?)
            """;
    private static String SQL_FIND_ALL = """
            SELECT acc.id, acc.id_user, acc.id_bank, acc.date_foundation, acc.balance, bk.name
            FROM account acc
            JOIN users usr on usr.id = acc.id_user
            JOIN bank bk on bk.id = acc.id_bank
            WHERE usr.id = ?;
            """;


    private static String SQL_DELETE_ACCOUNT = """
            DELETE FROM account WHERE id = ?
            """;



    @Override
    public AccountDTO save(AccountDTO entity) {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setObject(1, entity.getUser().getId());
            preparedStatement.setObject(2, entity.getBank().getId());
            preparedStatement.setObject(3, entity.getDate_foundation());
            preparedStatement.setObject(4, entity.getBalance());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next())
            {
                entity.setId(generatedKeys.getLong("id"));
            }
            return entity;

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public Optional<List<AccountDTO>> findAllByIdAccountUser(Long id)
    {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL)) {

            List<AccountDTO> accountDTO = new ArrayList<>();

            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                accountDTO.add(
                        AccountDTO.builder()
                                .Id(resultSet.getObject("id", Long.class))
                                .User(Users.builder().id(resultSet.getObject("id_user", Long.class)).build())
                                .Bank(Banks.builder().name(resultSet.getObject("name", String.class)).build())
                                .balance(resultSet.getObject("balance", BigDecimal.class))
                                .Date_foundation(resultSet.getObject("date_foundation", LocalDate.class))
                                .build()

                );
            }

            return Optional.of(accountDTO);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        try (Connection connection = ConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_ACCOUNT)) {
            preparedStatement.setObject(1, id);
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Optional<List<AccountDTO>> findAll() {
        return Optional.empty();
    }
    @Override
    public AccountDTO findById(Long id) {
        return null;
    }


    @Override
    public boolean update(AccountDTO entity) {
        return false;
    }

    public static AccountDAO getInstance()
    {
        return accountDTO;
    }
}

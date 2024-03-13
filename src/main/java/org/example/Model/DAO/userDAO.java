package org.example.Model.DAO;

import lombok.SneakyThrows;
import org.example.Model.Connection.ConnectionManager;
import org.example.Model.Entity.Enums.Gender;
import org.example.Model.Entity.Users;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public final class userDAO implements DAO<Integer, Users> {

    private static final userDAO INSTANCE = new userDAO();
    public static userDAO getInstance()
    {
        return INSTANCE;
    }

    private static String SQL_SAVE = """
                INSERT INTO users
                (first_name, last_name, patronymic, birthday, age, passport, email, phone, password, gender)
                values
                (?,?,?,?,?,?,?,?,?,?);
            """;

    private static String SQL_FIND_BY_EMAIL_AND_PASSWORD = """
                SELECT id, first_name, last_name, patronymic, birthday, age, passport, email, phone, gender
                FROM users WHERE email = ? AND password = ?;
            """;
    @Override
    public Users save(Users entity) {

        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE, RETURN_GENERATED_KEYS)) {

            preparedStatement.setObject(1, entity.getFirstName());
            preparedStatement.setObject(2, entity.getLastName());
            preparedStatement.setObject(3, entity.getPatronymic());
            preparedStatement.setObject(4, entity.getBirthday());
            preparedStatement.setObject(5, entity.getAge());
            preparedStatement.setObject(6, entity.getPassport());
            preparedStatement.setObject(7, entity.getEmail());
            preparedStatement.setObject(8, entity.getPhone());
            preparedStatement.setObject(9, entity.getPassword());
            preparedStatement.setObject(10, entity.getGender().name());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            entity.setId(resultSet.getObject(1, Long.class));
            return entity;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    public Optional<Users> findByEmailAndPassword(String email, String password)
    {
        try (Connection connection = ConnectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_EMAIL_AND_PASSWORD)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();


            Users users = null;

            if (resultSet.next())
            {
                users = Users.builder()
                        .id(resultSet.getObject("id", Long.class))
                        .firstName(resultSet.getObject("first_name", String.class))
                        .lastName(resultSet.getObject("last_name", String.class))
                        .patronymic(resultSet.getObject("patronymic", String.class))
                        .passport(resultSet.getObject("passport", String.class))
                        .age(resultSet.getObject("age", Integer.class))
                        .gender(Gender.valueOf(resultSet.getObject("gender", String.class)))
                        .email(resultSet.getObject("email", String.class))
                        .birthday(resultSet.getObject("birthday", LocalDate.class))
                        .phone(resultSet.getObject("phone", String.class))
                        .build();
            }

            return Optional.ofNullable(users);
        }
    }

    @Override
    public Optional<List<Users>> findAll() {
        return null;
    }

    @Override
    public Users findById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
    @Override
    public boolean update(Users entity) {
        return false;
    }
}

package ro.info.iasi.fiipractic.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ro.info.iasi.fiipractic.exception.UserNotFoundException;
import ro.info.iasi.fiipractic.model.User;
import ro.info.iasi.fiipractic.repository.mapper.UserRowMapper;

import java.util.List;

@Repository
public class UserDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM \"user\"", new UserRowMapper());
    }

    public int createUser(String firstName, String  lastName, String email, String password) {
        return jdbcTemplate.update("INSERT INTO \"user\"(FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) VALUES (?, ?, ?, ?)", firstName, lastName, email, password);
    }

    public int updateUser(String firstName, String  lastName, String email, String password, Integer id) {
        return jdbcTemplate.update("UPDATE \"user\" SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, PASSWORD = ? WHERE ID = ?", firstName, lastName, email, password, id);
    }

    public int deleteUser(int id) {
        return jdbcTemplate.update("DELETE FROM \"user\" WHERE ID = ?", id);
    }

    public User getUserById(Integer id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM \"user\" WHERE ID = ?", new UserRowMapper(), id);
        } catch (EmptyResultDataAccessException ex) {
            throw new UserNotFoundException(String.format("User with id %s was not found", id));
        }
    }
}

package com.example.Application.repository;

import com.example.Application.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAll(){
        return jdbcTemplate.query(
                "SELECT id, firstName, lastName, phoneNumber, email, password, balance FROM user",
                BeanPropertyRowMapper.newInstance(User.class));
    }

    public ResponseEntity<String> insertUser(List<User> userList){
        userList.forEach(user -> jdbcTemplate.update(
                "INSERT INTO user(firstName, lastName, password, phoneNumber, email) VALUES(?, ?, ?, ?, ?)",
                user.getFirstName(), user.getLastName(), user.getPassword(), user.getPhoneNumber(), user.getEmail()));

        return ResponseEntity.status(HttpStatus.OK).body("User Added to database!");
    }
}

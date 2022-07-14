package services;

import config.DBConfig;
import models.Employee;
import repositories.AuthRepo;
import shared.exception.AppException;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthService implements AuthRepo {

    private final DBConfig dbConfig;


    public AuthService() {
        dbConfig = new DBConfig();
    }

    public String login(String username, String password) {
        String id = "";
        try (Statement st = this.dbConfig.getConnection().createStatement()) {

            String query = String.format("SELECT * FROM employee \n" +
                    "WHERE emp_username=\"%s\" AND emp_password=\"%s\";", username, password);

            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                id = rs.getString("emp_id");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Credential");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}

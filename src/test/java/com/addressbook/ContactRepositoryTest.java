package com.addressbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.addressbook.repository.ContactRepository;

//import jakarta.activation.DataSource;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
@SpringBootTest
public class ContactRepositoryTest {

    @Autowired
    ContactRepository repository;

    @Autowired
    DataSource dataSource;

    @BeforeEach
    public void setup() throws SQLException {
        // Clean table
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM contacts");
        }

        // Auto insert test data
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO contacts (first_name, last_name, city) VALUES (?, ?, ?)")) {
            stmt.setString(1, "Muskan");
            stmt.setString(2, "Gupta");
            stmt.setString(3, "Delhi");
            stmt.executeUpdate();
        }
    }

    @Test
    public void givenDatabase_whenContactsFetched_shouldReturnRecords() {
        assertFalse(repository.getAllContacts().isEmpty());
    }

    @Test
    public void givenContact_whenCityUpdated_shouldReturnUpdatedRows() {
        int rows = repository.updateContactCity("Muskan", "Gupta", "Pune");
        assertTrue(rows > 0);
    }
}
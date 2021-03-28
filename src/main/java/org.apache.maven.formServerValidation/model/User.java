package org.apache.maven.formServerValidation.model;

import org.apache.maven.formServerValidation.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;

public class User {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String email;
    private String username;
    private String password;

    public User() {
    }

    public User(String firstName, String lastName, String birthDate, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void writeToFile(String fname) {
        Logger LOGGER = LoggerFactory.getLogger(AppProperties.class);
        try {
            FileWriter fileWriter = new FileWriter(fname, true);
            this.firstName=this.firstName.substring(0, 1).toUpperCase() + this.firstName.substring(1);
            fileWriter.write(this.firstName+"\n");
            this.lastName=this.lastName.substring(0, 1).toUpperCase() + this.lastName.substring(1);
            fileWriter.write(this.lastName+"\n");
            fileWriter.write(this.birthDate+"\n");
            fileWriter.write(this.email.toLowerCase()+"\n");
            fileWriter.write(this.username+"\n");
            fileWriter.write(this.password+"\n\n");
            fileWriter.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }

    }
}

package models;

public class User {

    String email;
    String password;

// *********************   Getters  *********************

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

// *********************   Setters  *********************

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }
}


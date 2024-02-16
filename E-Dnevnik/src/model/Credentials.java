package model;

import java.util.Random;

public abstract class Credentials {

    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private String uniqueID;

    private final Random random = new Random();

    protected Credentials(String name, String surname, String uniqueID) {
        this.name = name;
        this.surname = surname;
        this.username = name + surname + random.nextInt(100);
        this.uniqueID = uniqueID;
        this.email = username + "@unizd.hr";
        this.password = generateRandomString(random.nextInt(3,10));
    }

    private String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+";
        Random random = new Random();
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        StringBuilder stringBuilder = new StringBuilder(length);
        for (byte b : bytes) {
            int index = Math.abs(b) % characters.length();
            stringBuilder.append(characters.charAt(index));
        }
//        System.out.println("Generated this password -->" + stringBuilder + "<-- for user " + username + " with id " + uniqueID + ".");
        return stringBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Surname: ").append(surname).append("\n");
        sb.append("Username: ").append(username).append("\n");
        sb.append("Password: ").append(password).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Unique ID: ").append(uniqueID).append("\n");
        return sb.toString();
    }

}

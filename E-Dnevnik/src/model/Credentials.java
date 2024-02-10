package model;

import java.util.Random;

public abstract class Credentials {

    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private int id;
    private static int idCounter = 1;

    private final Random random = new Random();

    protected Credentials(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.username = name + surname + random.nextInt(100);
        this.id = idCounter++;
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
        System.out.println("Generated this password -->" + stringBuilder + "<-- for user " + username + " with id " + id);
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}

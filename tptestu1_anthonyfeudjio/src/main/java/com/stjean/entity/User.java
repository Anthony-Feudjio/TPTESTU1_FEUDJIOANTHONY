package com.stjean.entity;

import java.util.ArrayList;

public class User {

    private int id;
    private String name;
    private int age;
    private String email;
    private String phone;
    private String city;
    private double balancePersonnel;
    private static ArrayList<User> users = new ArrayList<>();

    // Constructor
    public User(int id, String name, int age, String email, String phone, String city, double balancePersonnel) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.balancePersonnel = balancePersonnel;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getBalancePersonnel() {
        return balancePersonnel;
    }

    public void setBalancePersonnel(double balancePersonnel) {
        this.balancePersonnel = balancePersonnel;
    }

    public static void addUser(User user) throws EmailInvalidException {
        if (!validateEmail(user.getEmail())) {
            throw new EmailInvalidException("Invalid email format.");
        }
        users.add(user);
    }

    // Method to delete user by ID
    public static void deleteUser(int id) throws DeletionInvalidException {
        User user = findUserById(id);
        if (user == null) {
            throw new DeletionInvalidException("User with ID " + id + " not found.");
        }
        users.remove(user);
    }

    // Method to list all users
    public static void listUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    // Method to display a user by ID
    public static void displayUser(int id) {
        User user = findUserById(id);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("User not found.");
        }
    }

    // Helper method to find a user by ID
    private static User findUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    // Email validation method
    public static boolean validateEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
public class EmailInvalidException extends Exception {
    public EmailInvalidException(String message) {
        super(message);
    }
}

public class DeletionInvalidException extends Exception {
    public DeletionInvalidException(String message) {
        super(message);
    }
}}

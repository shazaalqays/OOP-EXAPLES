/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author YOGA
 */
public class Person {
    
    private int id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private BloodType bloodType;
    private Gender gender;
    private int height;
    private int weight;

    public Person() {
    }

    public Person(String name, String surname, String username, String password, BloodType bloodType, Gender gender, int height, int weight) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.bloodType = bloodType;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    
    
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" + "id= " + id + ", name= " + name + ", surname= " + surname + ", username= " + username + ", password= " + password + ", bloodType= " + bloodType + ", gender= " + gender + ", height= " + height + ", weight= " + weight + '}';
    }
    
    
    
   
    
}

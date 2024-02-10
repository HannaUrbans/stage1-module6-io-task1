package com.epam.mjc.io;

import java.io.*;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.Map;

import static java.lang.System.in;
import static java.lang.System.out;


public class Profile {

    private String name;
    private Integer age;
    private String email;
    private Long phone;

    public Profile() {

    }

    public Profile(String name, Integer age, String email, Long phone) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }
//геттеры сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
//закончились
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Profile{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", email='").append(email).append('\'');
        sb.append(", phone=").append(phone);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profile profile = (Profile) o;
        return getName().equals(profile.getName())
                && getAge().equals(profile.getAge())
                && getEmail().equals(profile.getEmail())
                && getPhone().equals(profile.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getEmail(), getPhone());
    }

   }
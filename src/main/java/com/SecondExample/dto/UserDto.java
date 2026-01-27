package com.SecondExample.dto;

public class UserDto {
    private String name;
    private String role;
    private String email;
    private String mobileNumbers;

    public UserDto(String name, String role, String email, String mobileNumbers) {
        this.name = name;
        this.role = role;
        this.email = email;
        this.mobileNumbers = mobileNumbers;
    }

    public static void setId(Object o) {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(String mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }
}

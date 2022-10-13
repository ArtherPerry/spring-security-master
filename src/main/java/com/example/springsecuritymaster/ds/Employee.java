package com.example.springsecuritymaster.ds;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "FirstName cannot be empty.")
    @Pattern(regexp = "[A-Za-z-']*",message = "FirstName contains illegal characters.")
    private String firstName;

    @NotBlank(message = "LastName cannot be empty.")
    @Pattern(regexp = "[A-Za-z-']*",message = "LastName contains illegal characters.")
    private String lastName;

    @NotBlank(message = "PhoneNUmber cannot be empty.")
    @Pattern(regexp = "[0-9\\-+]*",message = "PhoneNumber contains illegal characters.")
    private String phoneNumber;

    @NotBlank(message = "Address cannot be empty.")
    @Pattern(regexp = "[\\w .\\-/,]*",message = "Address contains illegal characters.")
    private String address;

    @NotBlank(message = "CubicleNumber cannot be empty.")
    @Pattern(regexp = "[A-Za-z0-9\\-]*",message = "CubicleNumber contains illegal characters.")
    private String cubicleNo;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String phoneNumber, String address, String cubicleNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.cubicleNo = cubicleNo;
    }
}

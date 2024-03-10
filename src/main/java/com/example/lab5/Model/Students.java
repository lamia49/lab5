package com.example.lab5.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Students {
    private int id;
    private String name;
    private  int age;
    private String CollegeDgree;
    private boolean status;

}

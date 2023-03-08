package com.luxbp.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private int stuID;
    private String stuNum;
    private String stuName;
    private String stuGender;
    private int stuAge;
}

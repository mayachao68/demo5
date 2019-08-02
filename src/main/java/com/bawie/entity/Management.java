package com.bawie.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "manegement")
public class Management {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;
    private Integer distinction;
    private String clazz;
    private String num;
    private String name;
    private String birthday;
    private String sex;
    private String status;
    private String nation;
    private String phone;
    private String enrollmentdate;
    private String remark;
}

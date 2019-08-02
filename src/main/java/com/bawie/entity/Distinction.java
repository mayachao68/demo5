package com.bawie.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "distinction")
public class Distinction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer did;
    private String dname;
}

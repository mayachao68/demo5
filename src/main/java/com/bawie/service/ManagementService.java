package com.bawie.service;

import com.bawie.entity.Clazz;
import com.bawie.entity.Distinction;
import com.bawie.entity.Management;

import java.util.List;

public interface ManagementService {
    List<Management> list(String mohu);

    List<Management> list1();

    int deleteall(String ids);

    Management toupdate(Integer id);

    int updateManagement(Management management);

    List<Distinction> distinction();

    List<Clazz> clazz(String dname);


}

package com.bawie.service.servcieimpl;

import com.bawie.entity.Clazz;
import com.bawie.entity.Distinction;
import com.bawie.entity.Management;
import com.bawie.mapper.ManagementMapper;
import com.bawie.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementServiceImpl implements ManagementService {
    @Autowired
    ManagementMapper mapper;

    public List<Management> list(String mohu) {
        return mapper.list(mohu);
    }

    public List<Management> list1() {
        return mapper.list1();
    }

    public int deleteall(String ids) {
        String[] split = ids.split(",");
        int i=0;
        for (String id : split){
           i=mapper.deleteall(id);
        }
        return i;
    }

    public Management toupdate(Integer id) {
        return mapper.toupdate(id);
    }

    public int updateManagement(Management management) {
        return mapper.updateManagement(management);
    }

    public List<Distinction> distinction() {
        return mapper.distinction();
    }

    public List<Clazz> clazz(String dname) {
        return mapper.clazz(dname);
    }
}


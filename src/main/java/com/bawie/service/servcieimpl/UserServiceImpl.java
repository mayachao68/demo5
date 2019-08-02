package com.bawie.service.servcieimpl;

import com.bawie.entity.Menu;
import com.bawie.entity.User;
import com.bawie.mapper.MenuMapper;
import com.bawie.mapper.UserMapper;
import com.bawie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper mapper;


    public User login(String username) {
        return mapper.login(username);
    }

}

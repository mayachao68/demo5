package com.bawie.service;

import com.bawie.entity.Menu;
import com.bawie.entity.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MenuService {
    List<Menu> menulist(String username);
}

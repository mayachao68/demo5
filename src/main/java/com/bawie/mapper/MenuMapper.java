package com.bawie.mapper;

import com.bawie.entity.Menu;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

    public interface MenuMapper extends Mapper<Menu> {
        @Select("SELECT m.* from user u LEFT JOIN u_m um ON u.uid=um.uid\n" +
                "LEFT JOIN menu m ON um.mid=m.id where u.username=#{usernmae}")
    List<Menu> menulist(@RequestParam("username")String username);
}

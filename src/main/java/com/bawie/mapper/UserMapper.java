package com.bawie.mapper;

import com.bawie.entity.Menu;
import com.bawie.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    @Select("select * from user where username=#{username}")
    User login(@RequestParam("usernmae") String username);

}

package com.bawie.mapper;


import com.bawie.entity.Clazz;
import com.bawie.entity.Distinction;
import com.bawie.entity.Management;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ManagementMapper extends Mapper {

    @Select("select * from management where num like '%${mohu}%' or name like '%${mohu}%'")
    List<Management> list(@Param("mohu") String mohu);
    @Select("select * from management")
    List<Management> list1();
    @Update("update management set status='已删除' where sid=${id}")
    int deleteall(String id);
    @Select("select * from management where sid=#{id}")
    Management toupdate(Integer id);
    @Update("UPDATE `bwei`.`management` SET `distinction`=#{distinction}', `clazz`=#{clazz}, `num`=#{num}, `name`=#{name}, `birthday`=#{birthday}, `sex`=#{sex}, `status`=#{status}, `nation`=#{nation}', `phone`=#{phone}, `enrollmentdate`=#{enrollmentdate}, `remark`=#{remark} `sid`=#{sid}\n")
    int updateManagement(Management management);
    @Select("select * from distinction")
    List<Distinction> distinction();
    @Select("select c.* from clazz c LEFT JOIN distinction d ON c.did=d.did where d.dname=#{dname}")
    List<Clazz> clazz(@Param("dname")String dname);
}

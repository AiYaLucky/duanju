package com.shortstv.mapper;

import com.shortstv.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
* @author xu xiao wei
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-09-24 22:41:35
* @Entity com.shortstv.entity.User
*/
@Mapper
public interface UserMapper{

    int insertUser(User user);

    List<User> getAllUsers();

    User getUserByAccount(String account);

    int updateUser(User user);

}

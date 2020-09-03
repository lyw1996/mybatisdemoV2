package com.htsc.dao;

import com.htsc.domain.QueryVo;
import com.htsc.domain.QueryVoIds;
import com.htsc.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();
    User findById(Integer userId);
    int saveUser(User user);
    int updateUser(User user);
    int deleteUser(Integer userId);
    List<User> findByName(String username);
    int count();
    List<User> findByVo(QueryVo queryVo);
    List<User> findInIds(QueryVoIds voIds);
}

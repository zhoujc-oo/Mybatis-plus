package com.zhoujc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhoujc.entity.User;

import java.util.List;

/**
 * @Author zhoujc
 * @Date 2022/2/26
 */
public interface UserService extends IService<User> {

    List<User> findAll();

    int add(User user);

    int delete(Integer id);

    int update(User user);

    User select(Integer id);

    IPage<User> getPage(int currentPage, int pageSize, User user);
}

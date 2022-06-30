package com.zhoujc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhoujc.dao.UserMapper;
import com.zhoujc.entity.User;
import com.zhoujc.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhoujc
 * @Date 2022/2/26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findAll(){
        return userMapper.selectList(null);
    }

    @Override
    public int add(User user) {
        user.setName("zhoujc");
        user.setCountry("sajdk");
        user.setUrl("sdajk");
        user.setAlexa("sjdaksssssss");
        return userMapper.insert(user);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int update(User user) {
        user.setId(16);
        user.setName("zhoujc");
        user.setCountry("sajdk");
        user.setUrl("sdajk");
        user.setAlexa("sssssss");
        return userMapper.updateById(user);
    }

    @Override
    public User select(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public IPage<User> getPage(int currentPage, int pageSize, User user) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(user.getName()), User::getName, user.getName());
        lqw.like(Strings.isNotEmpty(user.getUrl()), User::getUrl, user.getUrl());
        lqw.like(Strings.isNotEmpty(user.getAlexa()), User::getAlexa, user.getAlexa());
        IPage page = new Page(currentPage, pageSize);
        userMapper.selectPage(page, lqw);
        return page;
    }
}

package com.zhoujc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhoujc.entity.User;
import com.zhoujc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author zhoujc
 * @Date 2022/2/26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public int addUser( User user) {
        return userService.add(user);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

    @PutMapping("/{up}")
    public int update(@RequestBody User user) {
        return userService.update(user);
    }

    /**
     * 需要路径变量时需要外加@PathVariable注解才能被锁定
     * 一个请求，只有一个RequestBody；一个请求，可以有多个RequestParam。
     */
    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.select(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<User> getPage(@PathVariable("currentPage") int currentPage, @PathVariable("pageSize") int pageSize, User user) {
        return userService.getPage(currentPage, pageSize, user);
    }
}

package com.example.mobilego.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.mobilego.entity.User;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/26-10:28
 * @Description：
 */
public interface IUserService extends IService<User> {

    boolean deleteAll();

    public List<User> selectListBySQL();
}
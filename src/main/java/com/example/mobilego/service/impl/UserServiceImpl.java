package com.example.mobilego.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.mobilego.entity.User;
import com.example.mobilego.mapper.UserMapper;
import com.example.mobilego.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： ygl
 * @date： 2018/3/26-10:29
 * @Description：
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public boolean deleteAll() {
        return retBool(baseMapper.deleteAll());
    }

    @Override
    public List<User> selectListBySQL() {
        return baseMapper.selectListBySQL();
    }

}
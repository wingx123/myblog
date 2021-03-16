package com.zx.myblog.service.impl;

import com.zx.myblog.entity.User;
import com.zx.myblog.mapper.UserMapper;
import com.zx.myblog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zx
 * @since 2021-03-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

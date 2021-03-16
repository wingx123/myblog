package com.zx.myblog.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zx.myblog.common.Result;
import com.zx.myblog.entity.User;
import com.zx.myblog.entity.dto.LoginDto;
import com.zx.myblog.service.UserService;
import com.zx.myblog.util.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AccountController {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response){
        User user = userService.getOne(new QueryWrapper<User>().eq("username", loginDto.getUsername()));
        Assert.notNull(user,"用户不存在");

        if(!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))){
            return Result.fail("密码不正确");
        }

        String jwt=jwtUtils.generateToken(user.getId());
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");

        return Result.succ(MapUtil.builder()
                .put("username", user.getUsername())
                .put("avatar", user.getAvatar())
                .put("email", user.getEmail())
                .map()
        );

    }
    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout(){
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }

}

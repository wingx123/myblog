package com.zx.myblog.service.impl;

import com.zx.myblog.entity.Blog;
import com.zx.myblog.mapper.BlogMapper;
import com.zx.myblog.service.BlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}

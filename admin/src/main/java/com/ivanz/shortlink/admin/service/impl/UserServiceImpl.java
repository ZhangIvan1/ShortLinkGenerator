package com.ivanz.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ivanz.shortlink.admin.dao.entity.UserDO;
import com.ivanz.shortlink.admin.dao.mapper.UserMapper;
import com.ivanz.shortlink.admin.dto.resp.UserRespDTO;
import com.ivanz.shortlink.admin.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


/**
 * 用户服务实现类
 * @author ivan
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    @Override
    public UserRespDTO getUserByUsername(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper=  Wrappers.lambdaQuery(UserDO.class).eq(UserDO::getUsername,username);
        UserDO userDO =baseMapper.selectOne(queryWrapper);
        UserRespDTO result = new UserRespDTO();
        if (userDO != null) {
            BeanUtils.copyProperties(userDO, result);
            return result;
        }else {
            return null;
        }
    }
}

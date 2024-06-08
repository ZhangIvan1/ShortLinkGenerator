package com.ivanz.shortlink.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ivanz.shortlink.admin.dao.entity.UserDO;
import com.ivanz.shortlink.admin.dto.resp.UserActualRespDTO;
import com.ivanz.shortlink.admin.dto.resp.UserRespDTO;

/**
 * 用户接口层
 * @author ivan
 */
public interface UserService extends IService<UserDO>  {

    /**
     * 根据用户名获取脱敏用户信息
     *
     * @param username 用户名
     * @return 用户返回脱敏实体
     */
    UserRespDTO getUserByUsername(String username);

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return 用户返回脱敏实体
     */
    UserActualRespDTO getActualUserByUsername(String username);
}

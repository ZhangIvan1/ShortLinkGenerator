package com.ivanz.shortlink.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ivanz.shortlink.admin.dao.entity.UserDO;
import com.ivanz.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.ivanz.shortlink.admin.dto.req.UserUpdateReqDTO;
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

    /**
     * 查询用户是否存在
     *
     * @param username 用户名
     * @return 是否存在 存在True 不存在False
     */
    Boolean hasUsername(String username);

    /**
     * 注册用户
     *
     * @param userRegisterReqDTO 用户注册请求实体
     */
    void register(UserRegisterReqDTO userRegisterReqDTO);

    /**
     * 根据用户名修改用户信息
     *
     * @param userUpdateReqDTO 用户更新请求实体
     */
    void update(UserUpdateReqDTO userUpdateReqDTO);
}

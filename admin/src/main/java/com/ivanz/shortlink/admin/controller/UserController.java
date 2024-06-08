package com.ivanz.shortlink.admin.controller;

import com.ivanz.shortlink.admin.common.convention.Result;
import com.ivanz.shortlink.admin.common.convention.Results;
import com.ivanz.shortlink.admin.common.convention.errorcode.BaseErrorCode;
import com.ivanz.shortlink.admin.common.convention.exception.ClientException;
import com.ivanz.shortlink.admin.dto.resp.UserActualRespDTO;
import com.ivanz.shortlink.admin.dto.resp.UserRespDTO;
import com.ivanz.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理控制层
 * @author ivan
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 根据用户名获取脱敏用户信息
     */
    @GetMapping("/api/shortlink/v1/user/{username}")
    public Result<UserRespDTO> getUserByUsername(@PathVariable("username") String username) {
        return Results.success(userService.getUserByUsername(username));
    }

    /**
     * 根据用户名获取无脱敏用户信息
     */
    @GetMapping("/api/shortlink/v1/actual/user/{username}")
    public Result<UserActualRespDTO> getActualUserByUsername(@PathVariable("username") String username) {
        return Results.success(userService.getActualUserByUsername(username));
    }

    /**
     * 查询用户是否存在
     */
    @GetMapping("/api/shortlink/v1/user/has-username/{username}")
    public Result<Boolean> hasUsername(@PathVariable("username") String username) {
        return Results.success(userService.hasUsername(username));
    }
}

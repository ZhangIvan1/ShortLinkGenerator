package com.ivanz.shortlink.admin.controller;

import com.ivanz.shortlink.admin.common.convention.Result;
import com.ivanz.shortlink.admin.common.convention.Results;
import com.ivanz.shortlink.admin.common.convention.errorcode.BaseErrorCode;
import com.ivanz.shortlink.admin.common.convention.exception.ClientException;
import com.ivanz.shortlink.admin.dto.req.UserLoginReqDTO;
import com.ivanz.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.ivanz.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.ivanz.shortlink.admin.dto.resp.UserActualRespDTO;
import com.ivanz.shortlink.admin.dto.resp.UserLoginRespDTO;
import com.ivanz.shortlink.admin.dto.resp.UserRespDTO;
import com.ivanz.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.calcite.adapter.java.Map;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理控制层
 *
 * @author ivan
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/short-link/v1")
public class UserController {

    private final UserService userService;

    /**
     * 根据用户名获取脱敏用户信息
     */
    @GetMapping("/user/{username}")
    public Result<UserRespDTO> getUserByUsername(@PathVariable("username") String username) {
        return Results.success(userService.getUserByUsername(username));
    }

    /**
     * 根据用户名获取无脱敏用户信息
     */
    @GetMapping("/actual/user/{username}")
    public Result<UserActualRespDTO> getActualUserByUsername(@PathVariable("username") String username) {
        return Results.success(userService.getActualUserByUsername(username));
    }

    /**
     * 查询用户是否存在
     */
    @GetMapping("/user/has-username/{username}")
    public Result<Boolean> hasUsername(@PathVariable("username") String username) {
        return Results.success(userService.hasUsername(username));
    }

    /**
     * 用户注册
     */
    @PostMapping("/user")
    public Result<Void> registerUser(@RequestBody UserRegisterReqDTO registerReqDTO) {
        userService.register(registerReqDTO);
        return Results.success();
    }

    /**
     * 修改用户信息
     */
    @PutMapping("/user")
    public Result<Void> updateUser(@RequestBody UserUpdateReqDTO userUpdateReqDTO) {
        userService.update(userUpdateReqDTO);
        return Results.success();
    }

    /**
     * 用户登录
     */
    @PostMapping("/user/login")
    public Result<UserLoginRespDTO> login(@RequestBody UserLoginReqDTO userLoginReqDTO) {
        UserLoginRespDTO userLoginRespDTO = userService.login(userLoginReqDTO);
        return Results.success(userLoginRespDTO);
    }

    /**
     * 检查用户是否登录
     */
    @GetMapping("/user/check-login")
    public Result<Boolean> checkLogin(@RequestParam("username") String username, @RequestParam("token") String token) {
        Boolean isLogin = userService.checkLogin(username, token);
        return Results.success(isLogin);
    }
}

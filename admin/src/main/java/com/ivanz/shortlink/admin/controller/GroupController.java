package com.ivanz.shortlink.admin.controller;

import com.ivanz.shortlink.admin.common.convention.Result;
import com.ivanz.shortlink.admin.common.convention.Results;
import com.ivanz.shortlink.admin.dto.req.GroupSaveReqDTO;
import com.ivanz.shortlink.admin.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短链接分组控制层
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/short-link/v1")
public class GroupController {

    private final GroupService groupService;

    @PostMapping("/group")
    public Result<Void> save(@RequestBody GroupSaveReqDTO groupSaveReqDTO){
        groupService.saveGroup(groupSaveReqDTO);
        return Results.success();
    }
}

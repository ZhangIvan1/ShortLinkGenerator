package com.ivanz.shortlink.admin.dto.req;

import lombok.Data;

/**
 * 短链接分组创建参数
 */
@Data
public class GroupSaveReqDTO {

    /**
     * 分组名称
     */
    private String groupName;
}

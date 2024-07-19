package com.ivanz.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ivanz.shortlink.admin.dao.entity.GroupDO;
import com.ivanz.shortlink.admin.dto.req.GroupSaveReqDTO;

/**
 * 短链接分组接口层
 */
public interface GroupService extends IService<GroupDO> {

    /**
     * 新增短链接分组
     * @param groupSaveReqDTO 短链接分组名
     */
    void saveGroup(GroupSaveReqDTO groupSaveReqDTO);

}

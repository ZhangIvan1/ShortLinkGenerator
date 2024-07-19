package com.ivanz.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ivanz.shortlink.admin.dao.entity.GroupDO;
import com.ivanz.shortlink.admin.dao.mapper.GroupMapper;
import com.ivanz.shortlink.admin.dto.req.GroupSaveReqDTO;
import com.ivanz.shortlink.admin.service.GroupService;
import com.ivanz.shortlink.admin.utils.RandomGenerator;
import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 短链接分组接口实现层
 */
@Slf4j
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {

    @Override
    public void saveGroup(GroupSaveReqDTO groupSaveReqDTO) {
        String gid;
        do {
            gid = RandomGenerator.generateRandom();
        } while (hasGid(gid));
        GroupDO groupDO = GroupDO.builder()
                .gid(gid)
                .name(groupSaveReqDTO.getGroupName())
                .build();
        baseMapper.insert(groupDO);
    }

    public Boolean hasGid(String gid) {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getGid, gid)
                // TODO 设置用户名
                .eq(GroupDO::getUsername, null);
        GroupDO GroupDO = baseMapper.selectOne(queryWrapper);
        return GroupDO != null;
    }
}

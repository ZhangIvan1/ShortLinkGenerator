package com.ivanz.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ivanz.shortlink.admin.dao.entity.GroupDO;
import com.ivanz.shortlink.admin.dao.mapper.GroupMapper;
import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Provider;

/**
 * 短链接分组接口实现层
 */
@Slf4j
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> {
}

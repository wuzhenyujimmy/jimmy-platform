package com.jimmy.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jimmy.base.db.DaoSupport;
import com.jimmy.module.dev.DevLog;
import com.jimmy.service.DevLogService;

@Service
@Transactional(readOnly = false)
public class DevLogServiceImpl extends DaoSupport<DevLog> implements
        DevLogService {

}

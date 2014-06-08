package com.jimmy.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jimmy.base.db.DaoSupport;
import com.jimmy.module.common.Tag;
import com.jimmy.service.TagService;

@Service
@Transactional(readOnly = false)
public class TagServiceImpl extends DaoSupport<Tag> implements TagService {

}

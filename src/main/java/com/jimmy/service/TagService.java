package com.jimmy.service;

import java.util.List;
import java.util.Set;

import com.jimmy.base.db.BaseDao;
import com.jimmy.module.po.Tag;

public interface TagService extends BaseDao<Tag> {

    Set<Tag> getAllTags(Tag tag);
    
    Set<Tag> getAllSubTags(Tag tag);
    
    List<Tag> getFirstLevelTags();

    List<Tag> getFirstLevelTagInPage(int currentPageIndex);
}

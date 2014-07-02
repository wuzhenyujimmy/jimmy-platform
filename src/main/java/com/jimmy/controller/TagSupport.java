package com.jimmy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jimmy.module.common.Tag;

public abstract class TagSupport {

    protected abstract String searchByTag(Tag tag);

    protected Map<String, String> buildTagCrumb(Tag tag) {
        List<Tag> tags = new ArrayList<Tag>();
        tags.add(0, tag);

        Tag t = tag;
        while (null != (t = t.getParent())) {
            tags.add(0, t);
        }

        Map<String, String> map = new HashMap<String, String>();
        for (Tag t1 : tags) {
            map.put(t1.getName(), buildTagHref(t1));
        }

        return map;
    }

    protected String buildTagHref(Tag tag) {
        String baseUrl = this.getClass().getAnnotation(RequestMapping.class).value()[0];
        return baseUrl + "/tag/" + tag.getId();
    }

    protected void listTag(Tag parentTag, HttpServletRequest request) {
        Set<Tag> childTags = parentTag.getChildren();

        if (!CollectionUtils.isEmpty(childTags)) {
            Map<String, String> map = new HashMap<String, String>();

            for (Tag tag : childTags) {
                map.put(tag.getName(), buildTagHref(tag));
                request.setAttribute("tagMap", map);
            }
        }
    }
}

package com.jimmy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jimmy.base.page.Page;
import com.jimmy.module.common.Tag;
import com.jimmy.service.TagService;
import com.jimmy.util.Constant;
import com.jimmy.util.GsonUtil;

@Controller
@RequestMapping("tag")
public class TagController {

    private static final int FIRST_LEVEL = 1;

    @Autowired
    TagService tagService;

    @RequestMapping("toSave")
    public String toSave(@RequestParam(required = false) String parentTagId, HttpServletRequest request) {

        List<Tag> tagSequence = new ArrayList<Tag>();

        if (StringUtils.isEmpty(parentTagId)) {

        } else {
            Tag tag = tagService.getEntity(parentTagId);

            if (null != tag) {
                tagSequence.add(0, tag);
                Tag parentTag = null;

                while (tag.getLevel() != FIRST_LEVEL) {
                    parentTag = tag.getParent();
                    tag = parentTag;
                    tagSequence.add(0, tag);
                }
            }
        }

        List<Tag> firstLevelTags = tagService.getFirstLevelTags();
        Map<String, List<Tag>> tagSequenceMap = new HashMap<String, List<Tag>>();

        for (int i = 0; i < tagSequence.size(); i++) {
            Tag tag = tagSequence.get(i);

            if (i == 0) {
                tagSequenceMap.put(tag.getId(), firstLevelTags);
            } else {
                tagSequenceMap.put(tag.getId(), tagSequence.get(i - 1).getChildren());
            }
        }

        request.setAttribute("tagSequenceMap", tagSequenceMap);

        return "tag/toSave";
    }

    @RequestMapping("/save")
    public String save(@RequestParam(required = false) String id, @RequestParam String name,
            @RequestParam(required = false) String parentTagId, HttpServletResponse response) {

        Tag tag = null;
        Tag parentTag = null;

        if (StringUtils.isEmpty(id)) {
            tag = new Tag();
        } else {
            tag = tagService.getEntity(id);
        }

        String redirectUrl = "";
        if (StringUtils.isEmpty(parentTagId)) {
            redirectUrl = "redirect:tag/list";
        } else {
            parentTag = tagService.getEntity(parentTagId);
            tag.setParent(parentTag);

            redirectUrl = "redirect:tag/list?parentTagId=" + parentTagId;
        }

        tagService.addOrUpdate(tag);

        GsonUtil.writePlainString(redirectUrl, response);
        return "";
    }

    @RequestMapping("/delete")
    public String delete() {
        return "";
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request, @RequestParam(required = false) String parentTagId,
            @RequestParam(required = false) Integer pageIndexFrom) {

        String whereSql = "";
        Tag parentTag = null;

        Page<Tag> page = null;
        if (pageIndexFrom != null && pageIndexFrom > 0) {
            page = new Page<Tag>("devlog/list", pageIndexFrom);
        } else {
            page = new Page<Tag>("devlog/list");
        }

        LinkedHashMap<String, String> orderMap = new LinkedHashMap<String, String>();
        orderMap.put("updateDate", Constant.ORDER_DESC);
        orderMap.put("createDate", Constant.ORDER_DESC);

        Tag[] parentTags = new Tag[1];
        if (StringUtils.isEmpty(parentTagId)) {
            page = tagService.getPagingResult(page, orderMap);
        } else {
            whereSql = "o.parent = ? ";
            parentTags[0] = tagService.getEntity(parentTagId);
            page = tagService.getPagingResult(page, whereSql, parentTags, orderMap);
        }

        request.setAttribute("parentTag", parentTag);
        request.setAttribute("page", page);

        return "tag/list";
    }
}

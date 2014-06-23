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

@Controller
@RequestMapping("tag")
public class TagController {

    private static final int FIRST_LEVEL = 1;

    @Autowired
    TagService tagService;

    @RequestMapping()
    public String defaults() {
        return "redirect:/tag/list";
    }

    @RequestMapping("toadd")
    public String toAdd(@RequestParam(required = false) String parentTagId, HttpServletRequest request) {

        if (!StringUtils.isEmpty(parentTagId)) {
            Tag tag = tagService.getEntity(parentTagId);
            request.setAttribute("tagSequenceMap", buildInheritTagSquence(tag));
        }

        return "tag/toSave";
    }

    @RequestMapping("toupdate")
    public String toUpdate(String id, HttpServletRequest request) {

        Tag tag = tagService.getEntity(id);

        request.setAttribute("tagSequenceMap", buildInheritTagSquence(tag.getParent()));
        request.setAttribute("tag", tag);

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

        if (!StringUtils.isEmpty(name)) {
            tag.setName(name);
        }

        String redirectUrl = "";
        if (StringUtils.isEmpty(parentTagId)) {
            tag.setLevel(FIRST_LEVEL);
            redirectUrl = "redirect:/tag/list";
        } else {
            parentTag = tagService.getEntity(parentTagId);
            tag.setParent(parentTag);

            redirectUrl = "redirect:/tag/list?parentTagId=" + parentTagId;
        }

        tagService.addOrUpdate(tag);

        // GsonUtil.writePlainString(redirectUrl, response);
        return redirectUrl;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String id, HttpServletResponse response) {
        tagService.disable(id);
        // GsonUtil.writePlainString(Constant.SUCCESS, response);
        return "redirect:/tag/list";
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request, @RequestParam(required = false) String parentTagId,
            @RequestParam(required = false) Integer pageIndexFrom) {

        String whereSql = "";
        Tag parentTag = null;

        Page<Tag> page = null;
        if (pageIndexFrom != null && pageIndexFrom > 0) {
            page = new Page<Tag>("tag/list", pageIndexFrom);
        } else {
            page = new Page<Tag>("tag/list");
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

    private Map<String, List<Tag>> buildInheritTagSquence(Tag tag) {

        List<Tag> tagSequence = new ArrayList<Tag>();

        Tag parentTag = null;

        if (null != tag) {
            tagSequence.add(0, tag);
            parentTag = tag.getParent();
        }

        if (null != parentTag) {
            tagSequence.add(0, parentTag);

            while (parentTag.getLevel() != FIRST_LEVEL) {
                parentTag = parentTag.getParent();

                if (null == parentTag) {
                    break;
                }

                tagSequence.add(0, parentTag);
            }
        }

        List<Tag> firstLevelTags = tagService.getFirstLevelTags();
        Map<String, List<Tag>> tagSequenceMap = new HashMap<String, List<Tag>>();

        for (int i = 0; i < tagSequence.size(); i++) {
            Tag t = tagSequence.get(i);

            if (i == 0) {
                tagSequenceMap.put(t.getId(), firstLevelTags);
            } else {

                List<Tag> childTagList = new ArrayList<Tag>();
                childTagList.addAll(tagSequence.get(i - 1).getChildren());

                tagSequenceMap.put(t.getId(), childTagList);
                System.out.println(tagSequence.get(i - 1).getName());
                System.out.println(tagSequence.get(i - 1).getChildren().size());
            }
        }

        return tagSequenceMap;
    }
}

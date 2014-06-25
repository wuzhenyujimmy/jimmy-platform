package com.jimmy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
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

    private static final String FIRST_LEVEL_MAP_KEY = "";
    
    private List<Tag> firstLevelTags;
    
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

        request.setAttribute("tagInheritJson", buildTagInheritJson());

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

        String redirectUrl = "redirect:/tag/list";
        if (StringUtils.isEmpty(parentTagId)) {
            tag.setLevel(FIRST_LEVEL);
            // redirectUrl = "redirect:/tag/list";
        } else {
            parentTag = tagService.getEntity(parentTagId);
            tag.setParent(parentTag);

            // redirectUrl = "redirect:/tag/list?parentTagId=" + parentTagId;
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
            @RequestParam(required = false) Integer currentPageIndex) {

        if (null == currentPageIndex || currentPageIndex < 0) {
            currentPageIndex = 0;
        }

        Page<Tag> page = new Page<Tag>("tag/list", currentPageIndex);

        LinkedHashMap<String, String> orderMap = new LinkedHashMap<String, String>();
        orderMap.put("updateDate", Constant.ORDER_DESC);
        orderMap.put("createDate", Constant.ORDER_DESC);

        String whereSql = "o.level = 1";
        Tag[] parentTags = null;
        if (!StringUtils.isEmpty(parentTagId)) {
            whereSql = "o.parent = ? ";
            parentTags = new Tag[1];
            parentTags[0] = tagService.getEntity(parentTagId);
        }
        page = tagService.getPagingResult(page, whereSql, parentTags, orderMap);

        request.setAttribute("page", page);
        request.setAttribute("treeMap", buildTagTree(page.getEntities()));

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

        List<Tag> firstLevelTags = getFirstLevelTags();
        Map<String, List<Tag>> tagSequenceMap = new HashMap<String, List<Tag>>();

        for (int i = 0; i < tagSequence.size(); i++) {
            Tag t = tagSequence.get(i);

            if (i == 0) {
                tagSequenceMap.put(tagSequence.get(0).getId(), firstLevelTags);
            } else {

                List<Tag> childTagList = new ArrayList<Tag>();
                childTagList.addAll(tagSequence.get(i - 1).getChildren());

                tagSequenceMap.put(t.getId(), childTagList);
            }
        }

        return tagSequenceMap;
    }

    private String buildTagInheritJson() {
        Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
        buildTagInheritJson(map, getFirstLevelTags());
        return GsonUtil.parser(map);
    }

    private void buildTagInheritJson(Map<String, Map<String, String>> map, List<Tag> tags) {


        if (!CollectionUtils.isEmpty(tags)) {
            for (Tag tag : tags) {
                Set<Tag> childTags = tag.getChildren();

                if (!CollectionUtils.isEmpty(childTags)) {
                    Map<String, String> valueMap = new HashMap<String, String>();

                    for (Tag childTag : childTags) {
                        valueMap.put(childTag.getId(), childTag.getName());
                    }

                    map.put(tag.getId(), valueMap);
                    buildTagInheritJson(map, new ArrayList<Tag>(childTags));
                }

            }
        }

    }

    private Map<String, List<Tag>> buildTagTree(List<Tag> firstLevelTags) {

        Map<String, List<Tag>> map = new HashMap<String, List<Tag>>();

        map.put(FIRST_LEVEL_MAP_KEY, firstLevelTags);
        buildRecursiveMap(map, firstLevelTags);

        return map;
    }

    private void buildRecursiveMap(Map<String, List<Tag>> map, List<Tag> tags) {

        if (!CollectionUtils.isEmpty(tags)) {

            for (Tag tag : tags) {
                List<Tag> childTags = new ArrayList<Tag>(tag.getChildren());

                if (!CollectionUtils.isEmpty(childTags)) {
                    map.put(tag.getId(), childTags);
                    buildRecursiveMap(map, childTags);
                }
            }
        }
    }

    private List<Tag> getFirstLevelTags() {
        if (this.firstLevelTags == null) {
            return tagService.getFirstLevelTags();
        }
        return this.firstLevelTags;
    }
}

package com.jimmy.controller;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

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

    @Autowired
    TagService tagService;

    @RequestMapping("/save")
    public String save(@RequestParam(required = false) String id, @RequestParam String name,
                    @RequestParam(required = false) String parentIds, HttpServletResponse response) {

        Tag entity = null;

        if (StringUtils.isEmpty(id)) {
            entity = new Tag();
        } else {
            entity = tagService.getEntity(id);
        }

        String redirectUrl = "";
        if (StringUtils.isEmpty(parentIds)) {
            redirectUrl = "redirect:tag/list";
        } else {
            String[] parentIdArray = parentIds.split(Constant.SPLIT);
            List<Tag> tags = tagService.getEntities(parentIdArray);
            Set<Tag> parentTags = new HashSet<Tag>();
            tags.addAll(tags);
            entity.setParents(parentTags);

            redirectUrl = "redirect:tag/list?parentId=" + parentIds;
        }

        tagService.addOrUpdate(entity);

        GsonUtil.writePlainString(redirectUrl, response);
        return "";
    }

    @RequestMapping("/delete")
    public String delete() {
        return "";
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request, @RequestParam(required = false) String parentId,
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

        whereSql = "o.parents in (?)";
        Tag[] parentTags = new Tag[1];
        if (StringUtils.isEmpty(parentId)) {
            parentTags[0] = null;
        } else {
            parentTags[0] = tagService.getEntity(parentId);
        }

        page = tagService.getPagingResult(page, whereSql, parentTags, orderMap);

        request.setAttribute("parentTag", parentTag);
        request.setAttribute("page", page);

        return "tag/list";
    }
}

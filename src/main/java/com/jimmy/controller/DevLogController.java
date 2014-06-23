package com.jimmy.controller;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jimmy.base.common.Article;
import com.jimmy.base.common.EntityStatus;
import com.jimmy.base.page.Page;
import com.jimmy.module.dev.DevLog;
import com.jimmy.service.DevLogService;
import com.jimmy.util.Constant;
import com.jimmy.util.GsonUtil;

@Controller
@RequestMapping("devlog")
public class DevLogController {
    @Autowired
    DevLogService devLogService;

    @RequestMapping("/save")
    public String save(@RequestParam(required = false) String id, @RequestParam String title,
                    @RequestParam String htmlContent, HttpServletResponse response) {

        if (StringUtils.isEmpty(id)) {
            Article article = new Article(title, htmlContent);
            DevLog entity = new DevLog(article, EntityStatus.NEW);

            devLogService.add(entity);
        } else {
            DevLog entity = devLogService.getEntity(id);

            Article article = entity.getArticle();
            article.setHtmlContent(htmlContent);
            article.setTitle(title);

            devLogService.update(entity);
        }

        GsonUtil.writePlainString("devlog/list", response);

        return "devlog/list";
    }

    @RequestMapping("/delete")
    public String delete() {
        return "devlog";
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request, @RequestParam(required = false) Integer pageIndexFrom) {
        Page<DevLog> page = null;

        if (pageIndexFrom != null && pageIndexFrom > 0) {
            page = new Page<DevLog>("devlog/list", pageIndexFrom);
        } else {
            page = new Page<DevLog>("devlog/list");
        }

        // List all DevLog entites in desc order
        LinkedHashMap<String, String> orderMap = new LinkedHashMap<String, String>();
        orderMap.put("updateDate", Constant.ORDER_DESC);
        orderMap.put("createDate", Constant.ORDER_DESC);

        page = devLogService.getPagingResult(page, orderMap);
        request.setAttribute("page", page);

        return "devlog/list";
    }

}

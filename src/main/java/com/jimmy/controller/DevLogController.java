package com.jimmy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jimmy.base.common.Article;
import com.jimmy.base.common.EntityStatus;
import com.jimmy.base.page.Page;
import com.jimmy.module.dev.DevLog;
import com.jimmy.service.DevLogService;

@Controller
@RequestMapping("devlog")
public class DevLogController {
    @Autowired
    DevLogService devLogService;

    @RequestMapping("/add")
    public String add(@RequestParam String title, @RequestParam String htmlContent) {

        Article article = new Article(title, htmlContent);
        DevLog entity = new DevLog(article, EntityStatus.NEW);
        devLogService.add(entity);

        return "devlog/list";
    }

    @RequestMapping("/update")
    public String update() {
        return "devlog";
    }

    @RequestMapping("/delete")
    public String delete() {
        return "devlog";
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request, @RequestParam int pageIndexFrom) {
        Page<DevLog> page = null;

        if (pageIndexFrom > 0) {
            page = new Page<DevLog>("devlog/list", pageIndexFrom);
        } else {
            page = new Page<DevLog>("devlog/list");
        }

        page = devLogService.getPagingResult(page);

        request.setAttribute("page", page);

        return "devlog/list";
    }

}

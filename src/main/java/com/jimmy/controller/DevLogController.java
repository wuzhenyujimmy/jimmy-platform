package com.jimmy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jimmy.base.common.Article;
import com.jimmy.base.common.EntityStatus;
import com.jimmy.module.dev.DevLog;
import com.jimmy.service.DevLogService;

@Controller
@RequestMapping("devlog")
public class DevLogController {
    @Autowired
    DevLogService devLogService;

    @RequestMapping("/add")
    public String add(@RequestParam String title,
            @RequestParam String htmlContent) {

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
    public String list() {
        return "devlog/list";
    }

}
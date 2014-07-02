package com.jimmy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jimmy.base.page.Page;
import com.jimmy.enums.DictionaryStatus;
import com.jimmy.module.po.Word;
import com.jimmy.module.vo.WordDto;
import com.jimmy.service.WordService;
import com.jimmy.util.ControllerUtil;
import com.jimmy.util.GsonUtil;

@Controller
@RequestMapping("word")
public class WordController {
    @Resource
    WordService wordService;

    @RequestMapping("/add")
    public void add(@RequestParam() String word, @RequestParam() String mean, @RequestParam() String example,
            HttpServletResponse response) {
        Word entity = new Word(word, mean, example);
        wordService.add(entity);
        GsonUtil.writePlainString("success", response);
    }

    @RequestMapping("/search")
    public void search(@RequestParam("keyWord") String keyWord, HttpServletResponse response) {
        List<Word> list = wordService.getSearchResult(keyWord);

        // convert entity to dto
        List<WordDto> dtoList = new ArrayList<WordDto>();
        for (Word word : list) {
            WordDto dto = new WordDto(word.getId(), word.getEn(), word.getCh(), word.getEg(), word.getStatus()
                    .getName());
            dtoList.add(dto);
        }
        GsonUtil.writeObjectJson(dtoList, response);

    }

    @RequestMapping("/query")
    public String query(@RequestParam(required = false) String status,
                    @RequestParam(required = false) Integer currentPageIndex,
            HttpServletRequest request) {
        Page<Word> page = null;

        if (null != currentPageIndex && currentPageIndex > 0) {
            page = new Page<Word>("word/query", currentPageIndex);
        } else {
            page = new Page<Word>("word/query");
        }

        if (!StringUtils.isEmpty(status)) {
            String whereSql = " o.status=" + DictionaryStatus.getIndexFromName(status);
            page = wordService.getPagingResult(page, whereSql);
        } else {
            page = wordService.getPagingResult(page);
        }

        request.setAttribute("page", page);
        request.setAttribute("status", DictionaryStatus.getAllEnum());
        request.setAttribute("currentStatus", status);
        ControllerUtil.setCommonRequestProperties(request, "word", "toAdd");
        return "word/home";
    }

    @RequestMapping("/updateStatus")
    public void modifyStatus(@RequestParam("id") String id, @RequestParam("status") String status,
            HttpServletResponse response) {
        wordService.modifyStatus(id, status);
        GsonUtil.writePlainString("success", response);
    }

    // change the index of words
    @RequestMapping("/changIndex")
    public void softableMove(@RequestParam("firstId") String firstId, @RequestParam("nextId") String nextId,
            @RequestParam("nextPage") int nextPage, HttpServletResponse response) {

        wordService.softableMove(firstId, nextId, nextPage);
        GsonUtil.writePlainString("success", response);
    }

    // insert word from search result

}

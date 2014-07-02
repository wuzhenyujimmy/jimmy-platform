package com.jimmy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jimmy.base.db.DaoSupport;
import com.jimmy.base.page.Page;
import com.jimmy.enums.DictionaryStatus;
import com.jimmy.module.po.Word;
import com.jimmy.service.WordService;

@Service
@Transactional
public class WordServiceImpl extends DaoSupport<Word> implements WordService {

    @SuppressWarnings("unchecked")
    public Word getFirst() {
        String hql = "from " + entityClassName + " o where o.former is null";
        Query query = getQuery(hql);
        List<Object> list = query.list();
        if (list.size() > 0) {
            return (Word) list.get(0);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public Word getLast() {
        String hql = "from " + entityClassName + " o where o.next is null";
        Query query = getQuery(hql);
        List<Object> list = query.list();
        if (list.size() > 0) {
            return (Word) list.get(0);
        }
        return null;
    }

    public void add(Word entity) {
        Word last = getLast();
        entity.setRemove(false);
        entity.setFormer(last);
        entity.setNext(null);
        entity.setStatus(DictionaryStatus.New);
        super.add(entity);
        if (last != null) {
            last.setNext(entity);
            update(last);
        }
    }

    public void delete(String id) {
        Word entity = getEntity(id);
        Word next = entity.getNext();
        Word former = entity.getFormer();

        former.setNext(next);
        next.setFormer(former);
        update(former);
        update(next);

        entity.setRemove(true);
        update(entity);
    }

    public void modifyStatus(String id, String status) {
        Word entity = getEntity(id);
        entity.setStatus(DictionaryStatus.getEnumFromName(status));
        update(entity);
    }

    public Page<Word> getPagingResult(Page<Word> page) {
        int firstResult = page.getFirstRecordQueryFrom();
        int maxResult = page.getRecordCountInPage();

        Word word = getFirst();
        List<Word> result = new ArrayList<Word>();
        if (null != word) {
            // find the first word to show
            for (int i = 0; i < firstResult; i++) {
                word = word.getNext();
            }

            // get maxResult words to show
            result.add(word);
            for (int i = 0; i < maxResult - 1; i++) {
                word = word.getNext();
                if (word != null) {
                    result.add(word);
                } else {
                    break;
                }
            }

            page.setEntities(result);

            // get all records count
            String hql = "select count(o) from " + entityClassName + " o";
            Query query = getQuery(hql);
            page.setTotalRecordCount(((Integer.valueOf(query.iterate().next().toString()).intValue())));
        } else {
            page.setEntities(result);
            page.setTotalRecordCount(0);
        }

        return page;
    }

    @SuppressWarnings("unchecked")
    public List<Word> getSearchResult(String keyWord) {
        // judge if the word is Chinese or English
        boolean isEnglish = true;

        if (keyWord.trim().charAt(0) > 127) {
            isEnglish = false;
        }

        String hql = "";

        if (isEnglish) {
            hql = "from " + entityClassName + " o where o.en like '%" + keyWord + "%'";
        } else {
            hql = "from " + entityClassName + " o where o.ch like '%" + keyWord + "%'";
        }

        Query query = getQuery(hql);
        return query.list();
    }

    public void softableMove(String firstId, String nextId, int nextPage) {
        Word firstWord = getEntity(firstId);
        Word firstFormer = firstWord.getFormer();
        Word firstNext = firstWord.getNext();

        if (firstFormer != null) {
            firstFormer.setNext(firstNext);
            update(firstFormer);
        }

        if (firstNext != null) {
            firstNext.setFormer(firstFormer);
            update(firstNext);
        }

        Word secondWord = getEntity(nextId);
        if (nextPage == 1) {
            secondWord = getEntity(nextId).getNext();
        }

        Word secondFormer = secondWord.getFormer();

        firstWord.setFormer(secondWord.getFormer());
        firstWord.setNext(secondWord);
        update(firstWord);

        secondWord.setFormer(firstWord);
        update(secondWord);

        if (secondFormer != null) {
            secondFormer.setNext(firstWord);
            update(secondFormer);
        }

    }

}

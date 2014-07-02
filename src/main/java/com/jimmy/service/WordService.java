package com.jimmy.service;

import java.util.List;

import com.jimmy.base.db.BaseDao;
import com.jimmy.module.po.Word;

public interface WordService extends BaseDao<Word> {
    /**
     * get the dictionary whose former is null
     * @return
     */
    Word getFirst();
    
	/**
	 * get the dictionary whose next is null
	 * @return
	 */
	Word getLast();
	
	/**
	 * query words from db according to key word
	 * @param searchString
	 * @return
	 */
	public List<Word> getSearchResult(String keyWord);
	
	/**
	 * modify the status of word
	 * @param id  id of the word
	 * @param status  new status of the word
	 */
    public void modifyStatus(String id, String status);

    void softableMove(String firstId, String nextId, int nextPage);
   
}

package com.tms.service.chapter;

import java.util.List;

import com.tms.base.DaoSupport;
import com.tms.entity.chapter.Chapter;

/**
 * @author mugbya
 * 
 * @version 2014年4月25日
 *
 */
public interface ChapterService extends DaoSupport<Chapter>{
	
	/**
	 * 通过科目id找到对应的章节
	 * @param id
	 * @return
	 */
	List<Chapter> findChapters(Integer id);
}

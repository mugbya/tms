package com.tms.service.chapter;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tms.base.DaoSupportImpl;
import com.tms.entity.chapter.Chapter;

/**
 * @author mugbya
 * 
 * @version 2014年4月25日
 *
 */
@Service
@Transactional
public class ChapterServiceImpl extends DaoSupportImpl<Chapter> implements ChapterService{

	@SuppressWarnings("unchecked")
	@Override
	public List<Chapter> findChapters(Integer id) {
	
		List<Chapter> chapters = getSession()
									.createQuery("FROM Chapter c WHERE c.subject.id=?")
									.setParameter(0, id).list();
		if (chapters.size()>0) {
			return chapters;
		}else {
			return  null;
		}

	}

}

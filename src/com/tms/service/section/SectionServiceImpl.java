package com.tms.service.section;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tms.base.DaoSupportImpl;
import com.tms.entity.section.Section;

/**
 * @author mugbya
 * 
 * @version 2014年4月25日
 *
 */
@Service
@Transactional
public class SectionServiceImpl extends DaoSupportImpl<Section>implements SectionService{

	@SuppressWarnings("unchecked")
	@Override
	public List<Section> findSection(Integer chapterId) {
		if (chapterId == null) {
			return null;
		}
		
		return getSession().createQuery("FROM Section s WHERE s.chapterId=?")
					.setParameter(0, chapterId).list();
	}

	@Override
	public Section findById(Integer sectionId) {
		return (Section) getSession().createQuery("FROM Section WHERE id=?").setParameter(0, sectionId).uniqueResult();
	}
          
}

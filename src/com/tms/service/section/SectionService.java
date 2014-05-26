package com.tms.service.section;

import java.util.List;

import com.tms.base.DaoSupport;
import com.tms.entity.section.Section;

/**
 * @author mugbya
 * 
 * @version 2014年4月25日
 *
 */
public interface SectionService extends DaoSupport<Section>{

	/**
	 * 根据章节的Id查询所有的小节
	 * @param chapterId
	 * @return
	 */
	List<Section> findSection(Integer chapterId);

	/**
	 * 根据小节Id查询小节信息
	 * @param sectionId
	 * @return
	 */
	Section findById(Integer sectionId);

}

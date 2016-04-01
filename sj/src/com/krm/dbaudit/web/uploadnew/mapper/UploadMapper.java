package com.krm.dbaudit.web.uploadnew.mapper;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
* @author Parker
* 
*/
@Repository("uploadMapperNew")
public interface UploadMapper {
	
	public Integer saveTable(List<Map<String, Object>> list);
	
	public Integer saveTableAlians(List<Map<String, Object>> list);
	
	public Long generateId();
	
}

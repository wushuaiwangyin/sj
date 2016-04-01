package com.krm.dbaudit.web.uploadnew.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.springframework.stereotype.Service;

import com.krm.dbaudit.web.uploadnew.mapper.UploadMapper;

/**
* @author Parker
* 
*/

@Service("uploadServiceNew")
public class UploadService {
	@Resource
	private UploadMapper uploadMapperNew;

	
	
	public Integer saveTable(List<Map<String, Object>> list){
		return uploadMapperNew.saveTable(list);
	}
	
	public Integer saveTableAlians(List<Map<String, Object>> list){
		return uploadMapperNew.saveTableAlians(list);
	}
	
	public Long generateId(){
		return uploadMapperNew.generateId();
	}
}

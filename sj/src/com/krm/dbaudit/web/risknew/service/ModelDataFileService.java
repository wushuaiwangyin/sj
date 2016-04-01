package com.krm.dbaudit.web.risknew.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.abel533.sql.SqlMapper;
import com.krm.dbaudit.common.base.ServiceMybatis;
import com.krm.dbaudit.web.risknew.mapper.ModelDataFileMapper;
import com.krm.dbaudit.web.risknew.model.ModelDataFile;

@Service("modelDataFileServiceNew")
public class ModelDataFileService extends ServiceMybatis<ModelDataFile>
{
	@Resource
	private SqlMapper sqlMapper;

	public SqlMapper getSqlMapper() {
		return sqlMapper;
	}

	public void setSqlMapper(SqlMapper sqlMapper) {
		this.sqlMapper = sqlMapper;
	}
	
	@Resource
	private ModelDataFileMapper modelDataFileMapperNew;
	
	
	public Long generateId(){
		return modelDataFileMapperNew.generateId();
	}
	
	public int saveFile(ModelDataFile modelDataFile){
		return modelDataFileMapperNew.saveFile(modelDataFile);
	}
	
	public ModelDataFile findById(Long id){
		return this.selectByPrimaryKey(id);
	}
	
	public Map<String,Object> getFile(Long id){
		String sql = "select * from model_data_file where id = "+id;
		return sqlMapper.selectOne(sql);
	}
}

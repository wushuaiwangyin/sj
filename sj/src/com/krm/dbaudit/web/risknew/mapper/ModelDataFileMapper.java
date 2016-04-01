package com.krm.dbaudit.web.risknew.mapper;

import org.springframework.stereotype.Repository;

import com.github.abel533.mapper.Mapper;
import com.krm.dbaudit.web.risknew.model.ModelDataFile;
@Repository("modelDataFileMapperNew")
public interface ModelDataFileMapper extends Mapper<ModelDataFile>
{
	public int saveFile(ModelDataFile modelDataFile);
	
	public Long generateId();
}

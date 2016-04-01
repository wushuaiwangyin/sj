package com.krm.dbaudit.web.risknew.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.github.abel533.mapper.Mapper;
import com.krm.dbaudit.web.risknew.model.DataDealModel;

@Repository("dataDealModelMapperNew")
public interface DataDealModelMapper extends Mapper<DataDealModel>
{
	public int fastDeal(DataDealModel dataDealModel);
	
	public DataDealModel findBydataId(Integer dataId);
	
	public DataDealModel findById(Integer id);
	
	public DataDealModel checkIsDealed(Integer dataId);

	public List<DataDealModel> findPageInfo(Map<String, Object> params);

	public Long generateId();
	
}

package com.krm.dbaudit.web.risknew.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("secondRiskModelMapperNew")
public interface SecondRiskModelMapper
{
	public List<Map<String, Object>> findResultByMonth(Map<String, Object> params);
	
	public List<Map<String, Object>> findResultByDay(Map<String, Object> params);
	
	public List<Map<String, Object>> findDetails(Map<String, Object> params);

	public int save(List<Map<String, Object>> list);
}

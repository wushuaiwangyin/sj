package com.krm.dbaudit.web.risknew.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.github.abel533.mapper.Mapper;
import com.krm.dbaudit.web.model.model.AuditModel;
import com.krm.dbaudit.web.risknew.model.ModelData;
import com.krm.dbaudit.web.risknew.model.RiskModelBase;
@Repository("riskDetectionMapperNew")
public interface RiskDetectionMapper extends Mapper<RiskModelBase>
{
	public List<RiskModelBase> findPageInfo(Map<String, Object> params);
	
	public RiskModelBase findById(Long id);
	
	public List<Map<String,Object>> findLastMonth(Map<String, Object> params);
	
	public List<Map<String,Object>> findYesterday(Map<String, Object> params);
	
	public List<Map<String,Object>> findLastMonthByStatus(Map<String,Object> params);
	
	public List<Map<String,Object>> findYesterdayByStatus(Map<String,Object> params);
	
	public List<Map<String,Object>> countByBar(Map<String, Object> params);
	
	public List<Map<String,Object>> findLastMonthByOrgan(Map<String, Object> params);
	
	public List<Map<String,Object>> findYesterdayByOrgan(Map<String, Object> params);

	public List<RiskModelBase> findPageInfoByAudit(Map<String, Object> params);

	public List<AuditModel> findAllAuditModel();

	public List<Map<String, Object>> findLastRunByMonth(Map<String, Object> params);

	public List<Map<String, Object>> findLastRunByYesterday(Map<String, Object> params); 
	
	public ModelData findModelDataByPkid(Integer id);


}

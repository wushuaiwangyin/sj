package com.krm.dbaudit.web.risknew.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.krm.dbaudit.web.risknew.service.SecondRiskService;

/**
 * 二次分析模型扫描任务
 * @author Parker
 *
 */
@Component
public class TaskJobNew
{
	@Resource
	private SecondRiskService secondRiskServiceNew;
	
	@Scheduled(cron="0 0 0 * * ?")    
    public void run() {  
		//获取客户号
		List<Map<String, Object>> list = secondRiskServiceNew.scan();
		List<Map<String, Object>> secondRiskModelList = new ArrayList<Map<String,Object>>();
		for (Map<String, Object> map : list)
		{
			//先判断客户号是否存在，存在就进入操作
			Map<String, Object> customer = secondRiskServiceNew.findCustomer(map.get("custno").toString().trim());
			if(customer != null && customer.size() > 0){
				secondRiskModelList = secondRiskServiceNew.getSecondRiskModel(map.get("custno").toString().trim());
				if(secondRiskModelList != null){
					secondRiskServiceNew.save(secondRiskModelList);
				}
			}
		}
    }  
}

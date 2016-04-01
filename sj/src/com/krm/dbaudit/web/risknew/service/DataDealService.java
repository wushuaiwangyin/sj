package com.krm.dbaudit.web.risknew.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.krm.dbaudit.common.base.ServiceMybatis;
import com.krm.dbaudit.web.risknew.mapper.DataDealModelMapper;
import com.krm.dbaudit.web.risknew.model.DataDealModel;
import com.krm.dbaudit.web.risknew.tabelMapper.QueryDetailInfoDao;


@Service("dataDealServiceNew")
public class DataDealService extends ServiceMybatis<DataDealModel>
{
	@Resource
	private DataDealModelMapper dataDealModelMapperNew;
	
	
	@Resource
	private QueryDetailInfoDao queryDetailInfoDao;
	
	public QueryDetailInfoDao getQueryDetailInfoDao()
	{
		return queryDetailInfoDao;
	}

	public void setQueryDetailInfoDao(QueryDetailInfoDao queryDetailInfoDao)
	{
		this.queryDetailInfoDao = queryDetailInfoDao;
	}

	
	
	/**
	 * 下发通知前查询是否已下发
	 * @param id
	 * @return
	 */
	public DataDealModel findBydataId(Integer dataId){
		return dataDealModelMapperNew.findBydataId(dataId);
	}
	
	
	/**
	 * 现场核实/非现场核实
	 * @param params
	 * @return
	 */
	public int dataDeal(DataDealModel dataDealModel){
		int count = 0;
		if(dataDealModel.getId() == null){
			count = this.insertSelective(dataDealModel);
		}else{
			//快速处理时，id是已经生成好的，所以此处直接插入，由于此处为处理，不涉及更改
			count = dataDealModelMapperNew.fastDeal(dataDealModel);
		}
		return count;
	}
	
	/**
	 * 快速处理
	 * @param dataDealModel
	 * @return
	 */
	public int fastDeal(DataDealModel dataDealModel){
		return this.insert(dataDealModel);
	}

	
	/**
	 * 下发通知成功后更改源数据状态
	 * @param dataId
	 * @param status
	 * @return
	 */
	public int updateDealStatus(Integer dataId, Integer status){
		return queryDetailInfoDao.updateDealStatus(dataId, status);
	}
	
	/**
	 * 从数据源下发先判断是否省级已处理
	 * @param dataId
	 * @return
	 */
	public DataDealModel checkIsDealed(Integer dataId){
		return dataDealModelMapperNew.checkIsDealed(dataId);
	}

	/**
	 * 查找历史处理记录
	 * @param params
	 * @return
	 */
	public PageInfo<DataDealModel> findPageInfo(Map<String, Object> params)
	{
		PageHelper.startPage(params);
		List<DataDealModel> list = dataDealModelMapperNew.findPageInfo(params);
		return new PageInfo<DataDealModel>(list);
	}
	
	/**
	 * 通过id查找处理记录
	 * @param id
	 * @return
	 */
	public DataDealModel findById(Integer id){
		return dataDealModelMapperNew.findById(id);
	}
	
	/**
	 * 生成自动主键
	 * @return
	 */
	public Long generateId(){
		return dataDealModelMapperNew.generateId();
	}
}


package com.krm.dbaudit.web.risknew.service;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.krm.dbaudit.common.base.ServiceMybatis;
import com.krm.dbaudit.web.risknew.mapper.DataNoticeModelMapper;
import com.krm.dbaudit.web.risknew.model.DataNoticeModel;
import com.krm.dbaudit.web.risknew.tabelMapper.QueryDetailInfoDao;


@Service("dataNoticeServiceNew")
public class DataNoticeService extends ServiceMybatis<DataNoticeModel>
{
	@Resource
	private DataNoticeModelMapper dataNoticeModelMapperNew;
	
	
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
	 * 查询表头
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> queryHeaders(Map<String, Object> params){
		return queryDetailInfoDao.queryHeaders(params);
	}
	
	
	/**
	 * 查询表数据
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> queryContents(Map<String, Object> params){
		return queryDetailInfoDao.queryContents(params);
	}
	
	
	public PageInfo<Map<String, Object>> findPageInfo(Map<String, Object> params){
		Page<Map<String, Object>> page = queryDetailInfoDao.findPageInfo(params);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String,Object>>(page);
		return pageInfo;
	}
	
	
	/**
	 * 下发通知
	 * @param params
	 * @return
	 */
	public int SendNotice(DataNoticeModel  notice){
		return dataNoticeModelMapperNew.insert(notice);
	}

	
	/**
	 * 下发通知成功后更改源数据通知状态
	 * @param dataId
	 * @param status
	 * @return
	 */
	public int updateStatus(Integer dataId, Integer status){
		return queryDetailInfoDao.updateNoticeStatus(dataId, status);
	}
	
	
	public PageInfo<DataNoticeModel> findNoticePageInfo(Map<String, Object> params) {
		PageHelper.startPage(params);
		List<DataNoticeModel> list = dataNoticeModelMapperNew.findPageInfo(params);
		return new PageInfo<DataNoticeModel>(list);
	}
	
	public List<DataNoticeModel> findNoticeByNumber(Map<String, Object> params) {
		List<DataNoticeModel> list = dataNoticeModelMapperNew.findNoticeByNumber(params);
		return list;
	}

	/**
	 * 查询详细信息
	 * @param id
	 * @return
	 */
	public DataNoticeModel findByPkId(Integer id) {
		return dataNoticeModelMapperNew.findByPkId(id);
	}
	
	/**
	 * 处理完成后终止通知状态
	 * @param dataId
	 * @param status
	 * @return
	 */
	public int endNoticeStatus(Map<String, Object> params){
		return dataNoticeModelMapperNew.endNoticeStatus(params);
	}
	
	/**
	 * 从通知书下发后更改通知状态
	 * @param dataId
	 * @param status
	 * @return
	 */
	public int updateNoticeStatus(Map<String, Object> params){
		return dataNoticeModelMapperNew.updateNoticeStatus(params);
	}

	
	public PageInfo<DataNoticeModel> findSendNoticePageInfo(Map<String, Object> params) {
		PageHelper.startPage(params);
		List<DataNoticeModel> list = dataNoticeModelMapperNew.findSendNoticePageInfo(params);
		return new PageInfo<DataNoticeModel>(list);
	}
	
	/**
	 * 下发前检测是否已下发
	 * @param params
	 * @return
	 */
	public DataNoticeModel checkIsReapted(Map<String, Object> params){
		return dataNoticeModelMapperNew.checkIsReapted(params);
	}
	
}

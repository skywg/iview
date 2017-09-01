package com.ovit.bee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.IDao.ColumnSettingsMapper;
import com.ovit.bee.IDao.InForMationDetailMapper;
import com.ovit.bee.IDao.KnowledgeDetailMapper;
import com.ovit.bee.IDao.PolicyDetailMapper;
import com.ovit.bee.pojo.ColumnSettings;
import com.ovit.bee.pojo.InForMationDetail;
import com.ovit.bee.pojo.KnowledgeDetail;
import com.ovit.bee.pojo.PolicyDetail;
import com.ovit.bee.service.ColumnSettingService;
@Service
public class ColumnSettingServiceImpl implements ColumnSettingService{
	@Autowired
	private ColumnSettingsMapper ColumnSettingDao;
	@Autowired
	private InForMationDetailMapper inForMationDetailMapper;
	@Autowired
	private PolicyDetailMapper policyDetailMapper;
	@Autowired
	private KnowledgeDetailMapper knowledgeDetailMapper;
	
	@Override
	public int insert(List<ColumnSettings> record) {
		
		return ColumnSettingDao.insert(record);
	}
	
	@Override
	public List<ColumnSettings> findColumnSetting(ColumnSettings record){	
		
		return ColumnSettingDao.findColumnSetting(record);
	}
	
	@Override
	public List<ColumnSettings> findColumnSet(ColumnSettings record){	
		 List<ColumnSettings> columnSetting  = new ArrayList<ColumnSettings>();
		 List<ColumnSettings> columnList = ColumnSettingDao.findColumnSet(record);
		 for(ColumnSettings info :columnList){	 
			 String[] label = info.getLabel().split(",");
			 for(int i=0;i<label.length;i++){
				 ColumnSettings columnSettings = new ColumnSettings();
				 columnSettings.setLabel(label[i]);
				 columnSettings.setColumnName(info.getColumnName());
				 columnSettings.setColumnId(info.getColumnId());
				 columnSetting.add(columnSettings);
			 }
			 
		 }
		return columnSetting;
	}
	
	@Override
	public List<InForMationDetail> findColumnInforMation(InForMationDetail record){
		return inForMationDetailMapper.findColumnInforMation(record);
		
	}
	
	@Override
	public List<PolicyDetail> findColumnPolicy(PolicyDetail record){
		return policyDetailMapper.findColumnPolicy(record);
	}
	
	@Override
	public List<KnowledgeDetail> findColumnKonwLedge(KnowledgeDetail record){
		return knowledgeDetailMapper.findColumnKnow(record);
	}

}

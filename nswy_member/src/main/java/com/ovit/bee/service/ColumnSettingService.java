package com.ovit.bee.service;

import java.util.List;

import com.ovit.bee.pojo.ColumnSettings;
import com.ovit.bee.pojo.InForMationDetail;
import com.ovit.bee.pojo.KnowledgeDetail;
import com.ovit.bee.pojo.PolicyDetail;

public interface ColumnSettingService {
	 int insert(List<ColumnSettings> record);

	 List<ColumnSettings> findColumnSetting(ColumnSettings record);

	 List<ColumnSettings> findColumnSet(ColumnSettings record);

	List<InForMationDetail> findColumnInforMation(InForMationDetail record);

	List<PolicyDetail> findColumnPolicy(PolicyDetail record);

	List<KnowledgeDetail> findColumnKonwLedge(KnowledgeDetail record);
}

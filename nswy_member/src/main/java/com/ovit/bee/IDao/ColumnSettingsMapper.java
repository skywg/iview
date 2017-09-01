package com.ovit.bee.IDao;

import java.util.List;

import com.ovit.bee.pojo.ColumnSettings;

public interface ColumnSettingsMapper {
    

    int insert(List<ColumnSettings> record);


    List<ColumnSettings> findColumnSet(ColumnSettings record);

    List<ColumnSettings> findColumnSetting(ColumnSettings record);
    
    int updateByPrimaryKey(ColumnSettings record);
}
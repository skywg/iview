package com.ovit.bee.IDao;

import java.util.List;

import com.ovit.bee.pojo.Industrialclassified;

public interface IndustrialclassifiedMapper {
    

    void insertIndu(Industrialclassified record);

    List<Industrialclassified> findIndu();
    
    List<Industrialclassified> findIndustrialclassified(Industrialclassified record);
    
   
    void updateIndu(Industrialclassified record);
}
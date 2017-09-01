package com.ovit.bee.IDao;

import com.ovit.bee.pojo.UserWorkExperience;

public interface UserWorkExperienceMapper {
    
    int insert(UserWorkExperience record);
  
    UserWorkExperience findUserWork(UserWorkExperience record);

    int updateUserWork(UserWorkExperience record);
}
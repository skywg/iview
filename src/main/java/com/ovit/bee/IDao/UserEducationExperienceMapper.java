package com.ovit.bee.IDao;

import com.ovit.bee.pojo.UserEducationExperience;

public interface UserEducationExperienceMapper {
 
    void insert(UserEducationExperience record);
    
    UserEducationExperience findUserEducation(UserEducationExperience record);

    void updateUserEducation(UserEducationExperience record);
}
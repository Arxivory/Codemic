package com.project.codemic.Codemic.service;


import com.project.codemic.Codemic.model.dto.ActivityDTO;
import com.project.codemic.Codemic.model.entity.Activity;
import com.project.codemic.Codemic.model.request.ActivityRO;

import java.util.List;
import java.util.Optional;

public interface ActivityService {
    void createActivity(ActivityRO activityRO);

    List<ActivityDTO> getAllActivities();

    Activity getActivityById(Integer id);

    void updateActivity(Integer id, ActivityRO activityRO);

    void deleteActivity(Integer id);

}

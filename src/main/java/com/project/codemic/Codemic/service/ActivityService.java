package com.project.codemic.Codemic.service;


import com.project.codemic.Codemic.model.entity.Activity;

import java.util.List;
import java.util.Optional;

public interface ActivityService {
    Activity createActivity(Activity activity);

    List<Activity> getAllActivities();

    Optional<Activity> getActivityById(Integer id);

    Activity updateActivity(Integer id, Activity activity);

    void deleteActivity(Integer id);

}

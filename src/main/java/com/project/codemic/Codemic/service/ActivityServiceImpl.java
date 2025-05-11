package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.entity.Activity;
import com.project.codemic.Codemic.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public Optional<Activity> getActivityById(Integer id) {
        return activityRepository.findById(id);
    }

    @Override
    public Activity updateActivity(Integer id, Activity activityDetails) {
        Optional<Activity> existingActivity = activityRepository.findById(id);

        if (existingActivity.isPresent()) {
            Activity updatedActivity = existingActivity.get();
            updatedActivity.setTitle(activityDetails.getTitle());
            updatedActivity.setContent(activityDetails.getContent());
            return activityRepository.save(updatedActivity);
        }
        return null;
    }

    @Override
    public void deleteActivity(Integer id) {
        Optional<Activity> activityOptional = activityRepository.findById(id);
        if (activityOptional.isPresent())
            activityRepository.deleteById(id);
    }
}

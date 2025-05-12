package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.exception.ResourceNotFoundException;
import com.project.codemic.Codemic.model.dto.ActivityDTO;
import com.project.codemic.Codemic.model.entity.Activity;
import com.project.codemic.Codemic.model.entity.Student;
import com.project.codemic.Codemic.model.entity.Subject;
import com.project.codemic.Codemic.model.mapper.ActivityMapper;
import com.project.codemic.Codemic.model.request.ActivityRO;
import com.project.codemic.Codemic.repository.ActivityRepository;
import com.project.codemic.Codemic.util.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ActivityServiceImpl implements ActivityService {

    public static final String ACTIVITIES = "Activites";

    public static final String ACTIVITY = "Activity";

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public void createActivity(ActivityRO activityRO) {
        try {
            Subject subject = subjectService.getSubjectById(activityRO.subjectId());

            activityRepository.save(activityRO.toEntity(null, subject));
        } catch (Exception e) {
            String errorMessage = MessageUtils.saveErrorMessage(ACTIVITY);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public List<ActivityDTO> getAllActivities() {
        try {
            List<Activity> activities = activityRepository.findAll();
            log.info(MessageUtils.retrieveSuccessMessage(ACTIVITIES));
            return activities.stream().map(activityMapper::toDTO).toList();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(ACTIVITIES);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public Activity getActivityById(Integer id) {
        try {
            Optional<Activity> activityOptional = activityRepository.findById(id);
            if (activityOptional.isEmpty())
                throw new Exception("Activity not found.");

            log.info(MessageUtils.retrieveSuccessMessage(ACTIVITY));
            return activityOptional.get();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(ACTIVITY);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public void updateActivity(Integer id, ActivityRO activityRO) {
        try {
            Optional<Activity> activityOptional = activityRepository.findById(id);
            if (activityOptional.isEmpty())
                throw new ResourceNotFoundException("Activity not found to be updated :(.");
            activityRepository.save(activityRO.toEntity(activityOptional.get(), activityOptional.get().getSubject()));
        } catch (Exception e) {
            String errorMessage = MessageUtils.saveErrorMessage(ACTIVITY);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public void deleteActivity(Integer id) {
        try {
            Optional<Activity> activityOptional = activityRepository.findById(id);

            if (activityOptional.isEmpty())
                throw new ResourceNotFoundException("Activity not found to be deleted :(.");

            activityRepository.deleteById(id);
        } catch (Exception e) {
            String errorMessage = MessageUtils.deleteErrorMessage(ACTIVITY);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }
}

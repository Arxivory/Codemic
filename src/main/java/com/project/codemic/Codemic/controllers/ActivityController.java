package com.project.codemic.Codemic.controllers;

import com.project.codemic.Codemic.model.request.ActivityRO;
import com.project.codemic.Codemic.model.request.StudentRO;
import com.project.codemic.Codemic.service.ActivityService;
import com.project.codemic.Codemic.service.StudentService;
import com.project.codemic.Codemic.util.MessageUtils;
import com.project.codemic.Codemic.util.ResponseUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("codemic/activity")
@RequiredArgsConstructor
public class ActivityController extends AbstractController {

    private ActivityService activityService;

    @GetMapping
    public ResponseEntity<?> getAllActivities() {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(ActivityService.ACTIVITIES),
                        activityService.getAllActivities()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getActivityById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(ActivityService.ACTIVITY),
                        activityService.getActivityById(id)
                )
        );
    }

    @PostMapping
    public ResponseEntity<?> createActivity(@Valid @RequestBody ActivityRO activityRO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    ResponseUtils.buildErrorResponse(
                            HttpStatus.BAD_REQUEST,
                            MessageUtils.VALIDATION_ERROR_MESSAGE,
                            getErrorResponse(bindingResult)
                    )
            );
        }

        activityService.createActivity(activityRO);

        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(ActivityService.ACTIVITY)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateActivity(@PathVariable Integer id, @Valid @RequestBody ActivityRO activityRO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    ResponseUtils.buildErrorResponse(
                            HttpStatus.BAD_REQUEST,
                            MessageUtils.VALIDATION_ERROR_MESSAGE,
                            getErrorResponse(bindingResult)
                    )
            );
        }

        activityService.updateActivity(id, activityRO);

        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(ActivityService.ACTIVITY)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteActivity(@PathVariable Integer id) {
        activityService.deleteActivity(id);
        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(ActivityService.ACTIVITY)
                )
        );
    }

}

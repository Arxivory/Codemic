package com.project.codemic.Codemic.controllers;

import com.project.codemic.Codemic.model.request.ModuleRO;
import com.project.codemic.Codemic.model.request.StudentRO;
import com.project.codemic.Codemic.service.ModuleService;
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
@RequestMapping("codemic/module")
@RequiredArgsConstructor
public class ModuleController extends AbstractController {

    private ModuleService moduleService;

    @GetMapping
    public ResponseEntity<?> getAllModules() {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(ModuleService.MODULES),
                        moduleService.getAllModules()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getModuleById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(ModuleService.MODULE),
                        moduleService.getModuleById(id)
                )
        );
    }

    @PostMapping
    public ResponseEntity<?> createModule(@Valid @RequestBody ModuleRO moduleRO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    ResponseUtils.buildErrorResponse(
                            HttpStatus.BAD_REQUEST,
                            MessageUtils.VALIDATION_ERROR_MESSAGE,
                            getErrorResponse(bindingResult)
                    )
            );
        }

        moduleService.createModule(moduleRO);

        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(ModuleService.MODULE)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateModule(@PathVariable Integer id, @Valid @RequestBody ModuleRO moduleRO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    ResponseUtils.buildErrorResponse(
                            HttpStatus.BAD_REQUEST,
                            MessageUtils.VALIDATION_ERROR_MESSAGE,
                            getErrorResponse(bindingResult)
                    )
            );
        }

        moduleService.updateModule(id, moduleRO);

        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(ModuleService.MODULE)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteModule(@PathVariable Integer id) {
        moduleService.deleteModule(id);
        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(ModuleService.MODULE)
                )
        );
    }

}

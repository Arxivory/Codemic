package com.project.codemic.Codemic.controllers;

import com.project.codemic.Codemic.model.request.PageRO;
import com.project.codemic.Codemic.model.request.StudentRO;
import com.project.codemic.Codemic.service.PageService;
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
@RequestMapping("codemic/page")
@RequiredArgsConstructor
public class PageController extends AbstractController{

    private PageService pageService;

    @GetMapping
    public ResponseEntity<?> getAllPages() {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(PageService.PAGES),
                        pageService.getAllPages()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPageById(@PathVariable Integer id) {
        return ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.retrieveSuccessMessage(PageService.PAGE),
                        pageService.getPageById(id)
                )
        );
    }

    @PostMapping
    public ResponseEntity<?> createPage(@Valid @RequestBody PageRO pageRO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    ResponseUtils.buildErrorResponse(
                            HttpStatus.BAD_REQUEST,
                            MessageUtils.VALIDATION_ERROR_MESSAGE,
                            getErrorResponse(bindingResult)
                    )
            );
        }

        pageService.createPage(pageRO);

        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(PageService.PAGE)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePage(@PathVariable Integer id, @Valid @RequestBody PageRO pageRO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(
                    ResponseUtils.buildErrorResponse(
                            HttpStatus.BAD_REQUEST,
                            MessageUtils.VALIDATION_ERROR_MESSAGE,
                            getErrorResponse(bindingResult)
                    )
            );
        }

        pageService.updatePage(id, pageRO);

        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(PageService.PAGE)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePage(@PathVariable Integer id) {
        pageService.deletePage(id);
        return  ResponseEntity.ok(
                ResponseUtils.buildSuccessResponse(
                        HttpStatus.OK,
                        MessageUtils.saveSuccessMessage(PageService.PAGE)
                )
        );
    }

}

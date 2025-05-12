package com.project.codemic.Codemic.controllers;

import com.project.codemic.Codemic.model.entity.Instructor;
import com.project.codemic.Codemic.model.entity.Page;
import com.project.codemic.Codemic.service.PageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
  @RequestMapping("codemic/students")
  public class PageController {

    @Autowired
    private PageService pageService;

    @PostMapping
    public ResponseEntity<Page> createPage(@Valid @RequestBody Page page) {
        return new ResponseEntity<>(pageService.createPage(page), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Page>> getAllPages() {
        return new ResponseEntity<>(pageService.getAllPages(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Page> getPageById(@PathVariable Integer id) {
      return pageService.getPageById(id)
              .map(page -> new ResponseEntity<>(page, HttpStatus.OK))
              .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
        
    @PutMapping("/{id}")
    public ResponseEntity<Page> updatePage(@PathVariable Integer id, @Valid @RequestBody Page pageDetails) {
        Page updatedPage = pageService.updatePage(id, pageDetails);
        return updatedPage != null
                ? new ResponseEntity<>(updatedPage, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Page> deletePage(@PathVariable Integer id) {
        return pageService.getPageById(id)
                .map(page -> {
                    pageService.deletePage(id);
                    return new ResponseEntity<>(page, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

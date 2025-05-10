package com.project.codemic.Codemic.controllers;

import com.project.codemic.Codemic.model.entity.Page;
import com.project.codemic.Codemic.service.PageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
  @RequestMapping("api/students")
  public class PageController {

    @Autowired
    private PageService pageService;

    @PostMapping
    public ResponseEntity<Page> createPage(@Valid @RequestBody Page page) {
        return new ResponseEntity<>pageService.createPage(page), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Page>> getAllPages() {
        return new ResponseEntity<>(pageService.getAllPages(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Page> getPagebyId(@PathVariable Long Id) {
      return pageService.getPageById(id)
        .map(page -> new ResponseEntity<>(page, HttpStatus.OK))
        orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
        
    @PutMapping("/{id}")
    public ResponseEntity<Page>updatePage(@PathVariable Long id, @Valid @RequestBody Page pageDetails) {
      return pageService getPageById(id)
        .map(existing Page -> { Page updatedPage = pageService.updatePage(id, pageDetails);
         return now ResponseEntity<>(updatedPage, HttpStatus.OK);
      })
        orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletePage(PathVariable Long id)
    return pageService.getPageById(id)
            .map(page -> {
              pageService.deletePage(id);
              return new ResponseEntity<void>(HttpStatus.NO_CONTENT);
            })
        orElse (new ResponseEntity<>(HttpStatus.NOT_FOUND));
}
}

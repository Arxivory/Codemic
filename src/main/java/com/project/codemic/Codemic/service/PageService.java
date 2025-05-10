package com.project.codemic.Codemic.service;
import com.project.codemic.Codemic.model.entity.Page;
import java.util.List;
import java.util.Optional;
public interface PageService {
    Page createPage(Page page);
    List<Page> getAllPages();
    Optional<Page> getPageById(Integer id);
    Page updatePage(Integer id, Page pageDetails);
    void deletePage(Integer id);
}
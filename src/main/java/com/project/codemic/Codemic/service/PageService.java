package com.project.codemic.Codemic.service;
import com.project.codemic.Codemic.model.dto.PageDTO;
import com.project.codemic.Codemic.model.entity.Page;
import com.project.codemic.Codemic.model.request.PageRO;

import java.util.List;
import java.util.Optional;
public interface PageService {

    void createPage(PageRO pageRO);

    List<PageDTO> getAllPages();

    Page getPageById(Integer id);

    void updatePage(Integer id, PageRO pageRO);

    void deletePage(Integer id);
}
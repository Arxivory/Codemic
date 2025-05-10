package com.project.codemic.Codemic.service;
import com.project.codemic.Codemic.model.entity.Page;
import com.project.codemic.Codemic.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PageServiceImpl implements PageService {
    @Autowired
    private PageRepository pageRepository;

    @Override
    public Page createPage(Page page) {
        return pageRepository.save(page);
    }
    @Override
    public List<Page> getAllPages() {
        return pageRepository.findAll();
    }

    @Override
    public Optional<Page> getPageById(Integer id) {
        return pageRepository.findById(id);
    }

    @Override
    public Page updatePage(Integer id, Page pageDetails) {
        Optional<Page> pageOptional = pageRepository.findById(id);
        if (pageOptional.isPresent()) {
            Page existingPage = pageOptional.get();
            existingPage.setContent(pageDetails.getContent());

            return pageRepository.save(existingPage);
        }
        return null;
    }

    @Override
    public void deletePage(Integer id) {
        Optional<Page> pageOptional = pageRepository.findById(id);
        if (pageOptional.isPresent())
            pageRepository.deleteById(id);
    }
}
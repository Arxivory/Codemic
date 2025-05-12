package com.project.codemic.Codemic.service;
import com.project.codemic.Codemic.exception.ResourceNotFoundException;
import com.project.codemic.Codemic.model.dto.PageDTO;
import com.project.codemic.Codemic.model.entity.Module;
import com.project.codemic.Codemic.model.entity.Page;
import com.project.codemic.Codemic.model.entity.Student;
import com.project.codemic.Codemic.model.mapper.PageMapper;
import com.project.codemic.Codemic.model.request.PageRO;
import com.project.codemic.Codemic.repository.PageRepository;
import com.project.codemic.Codemic.util.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PageServiceImpl implements PageService {

    public static final String PAGES = "Pages";

    public static final String PAGE = "Page";

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private PageMapper pageMapper;

    @Override
    public void createPage(PageRO pageRO) {
        try {
            Module module = moduleService.getModuleById(pageRO.moduleId());

            pageRepository.save(pageRO.toEntity(null, module));
        } catch (Exception e) {
            String errorMessage = MessageUtils.saveErrorMessage(PAGE);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public List<PageDTO> getAllPages() {
        try {
            List<Page> pages = pageRepository.findAll();
            log.info(MessageUtils.retrieveSuccessMessage(PAGES));
            return pages.stream().map(pageMapper::toDTO).toList();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(PAGES);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public Page getPageById(Integer id) {
        try {
            Optional<Page> pageOptional = pageRepository.findById(id);
            if (pageOptional.isEmpty())
                throw new Exception("Page not found.");

            log.info(MessageUtils.retrieveSuccessMessage(PAGE));
            return pageOptional.get();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(PAGE);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public void updatePage(Integer id, PageRO pageRO) {
        try {
            Optional<Page> pageOptional = pageRepository.findById(id);
            if (pageOptional.isEmpty())
                throw new ResourceNotFoundException("Page not found to be updated :(.");
            pageRepository.save(pageRO.toEntity(pageOptional.get(), pageOptional.get().getModule()));
        } catch (Exception e) {
            String errorMessage = MessageUtils.saveErrorMessage(PAGE);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public void deletePage(Integer id) {
        try {
            Optional<Page> pageOptional = pageRepository.findById(id);

            if (pageOptional.isEmpty())
                throw new ResourceNotFoundException("Page not found to be deleted :(.");

            pageRepository.deleteById(id);
        } catch (Exception e) {
            String errorMessage = MessageUtils.deleteErrorMessage(PAGE);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }
}
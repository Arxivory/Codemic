package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.exception.ResourceNotFoundException;
import com.project.codemic.Codemic.model.dto.ModuleDTO;
import com.project.codemic.Codemic.model.entity.Module;
import com.project.codemic.Codemic.model.entity.Student;
import com.project.codemic.Codemic.model.mapper.ModuleMapper;
import com.project.codemic.Codemic.model.request.ModuleRO;
import com.project.codemic.Codemic.repository.ModuleRepository;
import com.project.codemic.Codemic.util.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ModuleServiceImpl implements ModuleService {

    public static final String MODULES = "Modules";

    public static final String MODULE = "Module";

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public void createModule(ModuleRO moduleRO) {
        try {
            moduleRepository.save(moduleRO.toEntity(null, null));
        } catch (Exception e) {
            String errorMessage = MessageUtils.saveErrorMessage(MODULE);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public List<ModuleDTO> getAllModules() {
        try {
            List<Module> modules = moduleRepository.findAll();
            log.info(MessageUtils.retrieveSuccessMessage(MODULES));
            return modules.stream().map(moduleMapper::toDTO).toList();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(MODULES);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public Module getModuleById(Integer id) {
        try {
            Optional<Module> moduleOptional = moduleRepository.findById(id);
            if (moduleOptional.isEmpty())
                throw new Exception("Module not found.");

            log.info(MessageUtils.retrieveSuccessMessage(MODULE));
            return moduleOptional.get();
        } catch (Exception e) {
            String errorMessage = MessageUtils.retrieveErrorMessage(MODULE);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public void updateModule(Integer id, ModuleRO moduleRO) {
        try {
            Optional<Module> moduleOptional = moduleRepository.findById(id);
            if (moduleOptional.isEmpty())
                throw new ResourceNotFoundException("Module not found to be updated :(.");
            moduleRepository.save(moduleRO.toEntity(moduleOptional.get(), moduleOptional.get().getSubject()));
        } catch (Exception e) {
            String errorMessage = MessageUtils.saveErrorMessage(MODULE);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }

    @Override
    public void deleteModule(Integer id) {
        try {
            Optional<Module> moduleOptional = moduleRepository.findById(id);

            if (moduleOptional.isEmpty())
                throw new ResourceNotFoundException("Module not found to be deleted :(.");

            moduleRepository.deleteById(id);
        } catch (Exception e) {
            String errorMessage = MessageUtils.deleteErrorMessage(MODULE);
            log.error(errorMessage);
            throw new ServiceException(errorMessage, e);
        }
    }
}

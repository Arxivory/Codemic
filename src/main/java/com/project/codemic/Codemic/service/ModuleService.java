package com.project.codemic.Codemic.service;

import com.project.codemic.Codemic.model.dto.ModuleDTO;
import com.project.codemic.Codemic.model.entity.Module;
import com.project.codemic.Codemic.model.request.ModuleRO;

import java.util.List;
import java.util.Optional;

public interface ModuleService {

    String MODULES = "Modules";

    String MODULE = "Module";

    void createModule(ModuleRO moduleRO);

    List<ModuleDTO> getAllModules();

    Module getModuleById(Integer id);

    void updateModule(Integer id, ModuleRO moduleRO);

    void deleteModule(Integer id);

}

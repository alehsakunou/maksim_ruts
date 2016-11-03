package com.epam.jmp.jpa.service;

import com.epam.jmp.jpa.dao.ProjectDao;
import com.epam.jmp.jpa.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Maksim Ruts on 11/3/2016.
 * Project service implementation
 */
@Service
@Transactional
public class ProjectServiceImpl extends GenericServiceImpl<Project, ProjectDao> implements ProjectService {
    @Autowired
    private ProjectDao projectDao;

    @Override
    protected ProjectDao getDao() {
        return projectDao;
    }
}

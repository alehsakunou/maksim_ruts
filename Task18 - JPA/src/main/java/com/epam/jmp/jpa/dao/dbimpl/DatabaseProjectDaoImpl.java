package com.epam.jmp.jpa.dao.dbimpl;

import com.epam.jmp.jpa.dao.ProjectDao;
import com.epam.jmp.jpa.domain.Project;
import org.springframework.stereotype.Repository;

/**
 * Created by Maksim Ruts on 11/3/2016.
 * Database implementation of DAO for project
 */
@Repository
public class DatabaseProjectDaoImpl extends DatabaseGenericDaoImpl<Project> implements ProjectDao {
    @Override
    protected Class<Project> getType() {
        return Project.class;
    }
}

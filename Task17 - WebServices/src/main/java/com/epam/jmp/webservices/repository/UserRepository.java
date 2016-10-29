package com.epam.jmp.webservices.repository;

import com.epam.jmp.webservices.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Maksim Ruts on 10/29/2016.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}

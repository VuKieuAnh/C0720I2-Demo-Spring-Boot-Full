package com.codegym.wdbsspringboot.repository;

import com.codegym.wdbsspringboot.model.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface IAppUserRepository extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}

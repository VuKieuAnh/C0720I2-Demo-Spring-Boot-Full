package com.codegym.wdbsspringboot.service.userservice;


import com.codegym.wdbsspringboot.model.AppUser;

public interface IAppUserService {
    AppUser getUserByUsername(String username);
    AppUser getCurrentUser();
}

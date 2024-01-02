package com.universe.use_case.login;

import com.universe.entity.user.User;

public interface LoginUserDataAccessInterface {


    User get(Integer id);

    Integer existsByUsernameAndPassword(String username, String password);
}

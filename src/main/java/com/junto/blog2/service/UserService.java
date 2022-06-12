package com.junto.blog2.service;

import com.junto.blog2.po.User;

public interface UserService {
    User checkUser(String username,String password);
}

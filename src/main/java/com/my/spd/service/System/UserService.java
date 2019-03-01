package com.my.spd.service.System;

import com.my.spd.pojo.User;

/**
 * Created by YangYuFan on 2019/2/1.
 */
public interface UserService {
    User getUserOnLogin(String username);
}

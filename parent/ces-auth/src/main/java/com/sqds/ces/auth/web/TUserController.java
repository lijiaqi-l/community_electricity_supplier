package com.sqds.ces.auth.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 李嘉琪
 * @since 2020-10-16
 */
@RestController
@RequestMapping("/admin/tUser")
public class TUserController {

    @GetMapping("/user/info")
    public Principal user(Principal member) {
        return member;
    }
}

package com.sqds.ces.auth.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.sqds.ces.auth.entity.TUser;
import com.sqds.ces.auth.mapper.TUserMapper;
import com.sqds.ces.auth.service.ITUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 李嘉琪
 * @since 2020-10-16
 */
@Service
@Slf4j
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService, UserDetailsService {

    @Autowired
    ITUserService itUserService;


    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("用户名=====",s);
        Wrapper wrapper = new EntityWrapper<>();
        wrapper.eq("username",s);
        TUser tUser = itUserService.selectOne(wrapper);
        if (tUser==null){
            throw new UsernameNotFoundException("用户名错误");
        }else{
            log.info(passwordEncoder.encode(tUser.getPassword()));
            Integer role = tUser.getRole();
            log.info("用户密码",tUser.getPassword());
            return new User(s,tUser.getPassword(), AuthorityUtils.createAuthorityList("admin"));

        }
    }
}

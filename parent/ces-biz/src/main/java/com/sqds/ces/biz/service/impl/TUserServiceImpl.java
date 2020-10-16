package com.sqds.ces.biz.service.impl;

import com.sqds.ces.biz.entity.TUser;
import com.sqds.ces.biz.mapper.TUserMapper;
import com.sqds.ces.biz.service.ITUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}

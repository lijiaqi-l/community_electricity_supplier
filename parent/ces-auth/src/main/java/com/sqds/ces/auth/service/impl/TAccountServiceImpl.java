package com.sqds.ces.auth.service.impl;

import com.sqds.ces.auth.entity.TAccount;
import com.sqds.ces.auth.mapper.TAccountMapper;
import com.sqds.ces.auth.service.ITAccountService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商家账户 服务实现类
 * </p>
 *
 * @author 李嘉琪
 * @since 2020-10-16
 */
@Service
public class TAccountServiceImpl extends ServiceImpl<TAccountMapper, TAccount> implements ITAccountService {

}

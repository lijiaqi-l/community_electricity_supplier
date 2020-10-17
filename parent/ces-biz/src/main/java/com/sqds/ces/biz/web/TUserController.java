package com.sqds.ces.biz.web;


import com.qpx.jxc.common.vo.ResultEntity;
import org.springframework.web.bind.annotation.RequestMapping;
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

    /**
     * 返回用户信息
     * @return
     */
    @RequestMapping("/info")
    public ResultEntity getUserInfo(Principal member){
        return ResultEntity.ok(member);
    }

}

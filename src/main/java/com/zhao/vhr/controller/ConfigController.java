package com.zhao.vhr.controller;

import com.zhao.vhr.Common.HrUtils;
import com.zhao.vhr.Service.MenuService;
import com.zhao.vhr.bean.Hr;
import com.zhao.vhr.bean.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 登录后即可访问，用于获取配置信息,如角色等资源
 */
@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    private MenuService menuService;
    @RequestMapping("/sysmenu")
    public List<Menu> sysmenu(){
        return menuService.getMenusByHrId();
    }

    @RequestMapping("/hr")
    public Hr currentUser(){
        return HrUtils.getCurrentHr();
    }
}

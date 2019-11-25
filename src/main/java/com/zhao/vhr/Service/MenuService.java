package com.zhao.vhr.Service;

import com.zhao.vhr.Common.HrUtils;
import com.zhao.vhr.bean.Menu;
import com.zhao.vhr.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@CacheConfig(cacheNames = "menus_cache")
public class MenuService {
    @Autowired
    private MenuMapper menuMapper;

    public List<Menu> getAllMenu(){
        return menuMapper.getAllMenu();
    }
    public List<Menu> getMenusByHrId(){
        return menuMapper.getMenusByHrId(HrUtils.getCurrentHr().getId());
    }
    public List<Menu>menuTree(){
        return menuMapper.menuTree();
    }
    public List<Long> getMenusByRid(Long rid){
        return menuMapper.getMenusByRid(rid);
    }
}

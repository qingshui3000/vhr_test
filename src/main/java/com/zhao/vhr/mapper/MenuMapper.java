package com.zhao.vhr.mapper;

import com.zhao.vhr.bean.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MenuMapper {
    List<Menu> getAllMenu();
    List<Menu> getMenuByHrId(Long hrId);
    List<Menu> menuTree();
    List<Long> getMenusByRid(Long rid);
}

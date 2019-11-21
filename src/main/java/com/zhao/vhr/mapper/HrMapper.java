package com.zhao.vhr.mapper;

import com.zhao.vhr.bean.Hr;
import com.zhao.vhr.bean.Role;

import java.util.List;

public interface HrMapper {
    Hr loadUserByUsername(String username);


    List<Role> getRolesByHrId(Long id);
}

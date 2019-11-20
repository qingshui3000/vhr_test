package com.zhao.vhr.config;

import com.zhao.vhr.Service.MenuService;
import com.zhao.vhr.bean.Menu;
import com.zhao.vhr.bean.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class CustomMetaDataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private MenuService menuService;
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<Menu> allMenu = menuService.getAllMenu();
        for(Menu menu : allMenu){
            if(antPathMatcher.match(menu.getUrl(),requestUrl)
                && menu.getRoles().size() > 0){
                List<Role> roles = menu.getRoles();
                int size = roles.size();
                String[] values = new String[size];
                for(int i = 0;i < size;i++){
                    values[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(values);
            }
        }
        //未匹配的资源通通跳转至登陆
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}

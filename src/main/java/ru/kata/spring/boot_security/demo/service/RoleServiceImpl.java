package ru.kata.spring.boot_security.demo.service;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Collection;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roleDao.mapRolesToAuthorities(roles);
    }

    @Override
    public List<Role> getAllURoles() {
        return roleDao.getAllURoles();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }
}

package edu.nwu.museum.service;

import edu.nwu.museum.dao.UserRoleMapper;
import edu.nwu.museum.domain.Role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;

    public List<Role> findByUserId(String userId) {
        return userRoleMapper.findByUserId(userId);
    }
}

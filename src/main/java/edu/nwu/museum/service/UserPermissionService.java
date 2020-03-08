package edu.nwu.museum.service;

import edu.nwu.museum.dao.UserPermissionMapper;
import edu.nwu.museum.domain.Permission;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPermissionService {
    @Autowired
    UserPermissionMapper userPermissionMapper;

    public List<Permission> findByUserId(String userId) {
        return userPermissionMapper.findByUserId(userId);
    }
}

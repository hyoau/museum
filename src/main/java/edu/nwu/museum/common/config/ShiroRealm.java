package edu.nwu.museum.common.config;

import edu.nwu.museum.common.jwt.JWTToken;
import edu.nwu.museum.common.jwt.JWTUtil;
import edu.nwu.museum.domain.User;
import edu.nwu.museum.service.UserPermissionService;
import edu.nwu.museum.service.UserRoleService;
import edu.nwu.museum.service.UserService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.security.sasl.AuthenticationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiroRealm extends AuthorizingRealm {
    private static final Logger LOGGER = LogManager.getLogger(ShiroRealm.class);

    @Autowired
    private UserService userService;

    // boilerplate code
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    // used for checkRole or checkPermission
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userId = JWTUtil.getUserId(principals.toString());
        User user = userService.findById(userId);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(user.getRole());
        return simpleAuthorizationInfo;
    }

    // verify user id and password
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth)
            throws RuntimeException {
        String token = (String) auth.getCredentials();
        String userId = JWTUtil.getUserId(token);
        if (userId == null) {
            throw new RuntimeException("I am sorry this token is invalid.");
        }

        User user = userService.findById(userId);
        if (user == null) {
            throw new RuntimeException("I am sorry this user does not exist.");
        }

        if (!JWTUtil.verify(token, userId, user.getPassword())) {
            throw new RuntimeException("There is an error in user id or password.");
        }

        return new SimpleAuthenticationInfo(token, token, "shiro_realm");
    }
}
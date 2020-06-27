package com.taoge.zxstbg.admin.loginmanage.realm;

import com.taoge.zxstbg.database.zxstbg.entity.SysUser;
import com.taoge.zxstbg.database.zxstbg.service.impl.SysUserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String usercode=(String)authenticationToken.getPrincipal();
        SysUser user=sysUserService.findUserByAccount(usercode);
        if(user==null){
            return null;
        }
        String salt="111111";
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user,user.getPassword(),ByteSource.Util.bytes(salt),"CustomRealm");
        return info;
    }
}

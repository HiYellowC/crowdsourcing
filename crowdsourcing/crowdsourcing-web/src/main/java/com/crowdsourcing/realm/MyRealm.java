package com.crowdsourcing.realm;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.crowdsourcing.pojo.TbUser;
import com.crowdsourcing.service.UserService;

public class MyRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		System.out.println("is executing doGetAuthorizationInfo");
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Session session = SecurityUtils.getSubject().getSession();
		Set<String> set = new HashSet<String>();
		set.add((String) session.getAttribute("role"));
		authorizationInfo.setRoles(set);
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) 
			throws AuthenticationException {
		String username = (String) token.getPrincipal();
		TbUser user = userService.getUserByUsername(username);
		if (user == null) {
			throw new UnknownAccountException();
		}
		if (user.getIsLock()) {
			throw new LockedAccountException();
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), 
				user.getPassword(), ByteSource.Util.bytes(user.getPasswordSalt()), getName());
		
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute("id", user.getId());
		session.setAttribute("role", user.getRole());
		
		return authenticationInfo;
	}
	public String getName() {
		return "MyRealm";
	}
}

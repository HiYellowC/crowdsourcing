package com.crowdsourcing.service;

import java.util.Date;
import java.util.List;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.crowdsourcing.mapper.TbUserMapper;
import com.crowdsourcing.pojo.TbUser;
import com.crowdsourcing.pojo.TbUserExample;
import com.crowdsourcing.pojo.TbUserExample.Criteria;

@Service
public class UserService {
	
	@Autowired
	private TbUserMapper tbUserMapper;
	
	/* type: 
	 * 1  完成task1
	 * 2  完成task2
	 * 3  完成task3
	 * 4 task1不合格
	 * 5 task2合格
	 */
	public void updateUserQuantityById(Long id, int type) throws Exception {
		TbUser tbUser = tbUserMapper.selectByPrimaryKey(id);
		if (tbUser == null) {
			throw new Exception();
		}
		if (type == 1) {
			tbUser.setTask1Quantity(tbUser.getTask1Quantity() + 1);
			tbUser.setScore(tbUser.getScore() + 1);
		} else if (type == 2) {
			tbUser.setTask2Quantity(tbUser.getTask2Quantity() + 1);
			tbUser.setScore(tbUser.getScore() + 1);
		} else if (type == 3) {
			tbUser.setTask3Quantity(tbUser.getTask3Quantity() + 1);
			tbUser.setScore(tbUser.getScore() + 1);
		} else if (type == 4) {
			tbUser.setTask1DoubtfulQuantity(tbUser.getTask1DoubtfulQuantity() + 1);
		} else if (type == 5) {
			tbUser.setScore(tbUser.getScore() + 3);
		}
		tbUser.setGmtModified(new Date());
		
		tbUserMapper.updateByPrimaryKeySelective(tbUser);
	}
	
	public void updateUserLockById(Long id, boolean lock) throws Exception{
		TbUser tbUser = new TbUser();
		tbUser.setId(id);
		tbUser.setIsLock(lock);
		tbUser.setGmtModified(new Date());
		
		tbUserMapper.updateByPrimaryKeySelective(tbUser);
	}

	public void updateUserPermissionById(Long id, Integer addPermission) throws Exception{
		TbUser tbUser = getUserById(id);
		
		Integer permission = tbUser.getPermission();
		permission = permission | (1 << (addPermission - 1));
		
		tbUser.setPermission(permission);
		tbUser.setGmtModified(new Date());
		
		tbUserMapper.updateByPrimaryKeySelective(tbUser);
	}
	
	public List<TbUser> getUsers() throws Exception {
		TbUserExample example = new TbUserExample();
		return tbUserMapper.selectByExample(example);
	}
	
	public TbUser getUserById(Long id) {
		return tbUserMapper.selectByPrimaryKey(id);
	}
	
	public TbUser getUserByUsername(String username) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TbUser> list = tbUserMapper.selectByExample(example);
		return list.size() == 0 ? null : list.get(0);
	}
	
	public void saveUser(String username, String password) throws DuplicateKeyException, Exception{
		
		SecureRandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
		String passwordSalt = randomNumberGenerator.nextBytes().toHex();
		String MD5Password = new Md5Hash(password, passwordSalt).toString();
		
		TbUser user = new TbUser();
		user.setUsername(username);
		user.setPassword(MD5Password);
		user.setPasswordSalt(passwordSalt);
		user.setRole("user");
		user.setIsLock(false);
		user.setScore(0);
		user.setTask1Quantity(0);
		user.setTask2Quantity(0);
		user.setTask3Quantity(0);
		user.setTask1DoubtfulQuantity(0);
		user.setTask2DoubtfulQuantity(0);
		user.setTask3DoubtfulQuantity(0);
		user.setPermission(0);
		user.setGmtCreate(new Date());
		user.setGmtModified(new Date());
		
		tbUserMapper.insert(user);
	}
	
}

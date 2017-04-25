package com.javen.service.impl;
import javax.annotation.Resource;  

import org.springframework.stereotype.Service;  
import com.javen.dao.userMapper;
import com.javen.model.User;
import com.javen.service.IUserService;
  
  
@Service("IUserService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private userMapper userDao;  
    
    public User getUserById(int userId) {  
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId);  
    }
    
    public User selectUserByUsername(String userName) {
//    	TODO Auto-generated method stub  
    	return this.userDao.selectByName(userName);
    }
    
    public User selectUserByEmail(String email) {
//    	TODO Auto-generated method stub  
    	return this.userDao.selectByEmail(email);
    }

	public User selectUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.selectUser(user);
	}  

	public int deleteUserById(int userId) {
		// TODO Auto-generated method stub  
		return this.userDao.deleteByPrimaryKey(userId);
	}
	
	public int insertUser(User user) {
		return this.userDao.insert(user);
	}
	
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.updateByPrimaryKey(user);
	}
	
	public void setUserdaoIMP(userMapper userdaoIMP) {
		this.userDao = userdaoIMP;
	}

	public userMapper getUserdaoIMP() {
		return userDao;
	}
}
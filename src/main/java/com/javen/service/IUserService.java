package com.javen.service;  

import com.javen.model.User;

  
public interface IUserService {  
    public User getUserById(int userId);
    public User selectUser(User user);
    public User selectUserByUsername(String userName);
    public User selectUserByEmail(String email);
    public int insertUser(User user);
    public int updateUser(User user);
    public int deleteUserById(int user_id);
}
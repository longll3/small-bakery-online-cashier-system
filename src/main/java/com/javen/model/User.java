package com.javen.model;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userEmail;

    private int age;

    public int getId() {
        return userId;
        
    }

    public void setId(int id) {
        this.userId = id;
    }

    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {

//trim �Ǹ��������ȥ������ؼ��ֵı�ǩ������������ʵ�� where �� set ��Ч����
    	//trim��������ʼ�ͽ�β�Ŀո�ɾ��
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return userPassword;
    }

    public void setPassword(String i) {
        this.userPassword = (i == null) ? null : i.trim();
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    @Override //��������һ�������س�����ĺ�����method
    public String toString() {
        return "User [id=" + userId + ", userName=" + userName + ", password="
                + userPassword + ", age=" + age + "]";
    }
    
    
}
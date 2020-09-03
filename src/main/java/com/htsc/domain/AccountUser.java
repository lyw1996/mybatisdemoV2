package com.htsc.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * <h3>mybatisdemoV2</h3>
 * <p></p>
 *
 * @author : liuyuwei
 * @date : 2020-09-02 16:49
 **/
public class AccountUser implements Serializable {

    private Integer id;
    private Account account;
    private User user;

    public AccountUser() {
        this.account=new Account();
        this.user=new User();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getUid(){
        return account.getUid();
    }

    public void setUid(Integer uid){
        account.setUid(uid);
    }

    public Double getMoney(){
        return account.getMoney();
    }

    public void setMoney(Double money){
        account.setMoney(money);
    }

    public String getUsername(){
        return user.getUserName();
    }

    public void setUsername(String userName){
        user.setUserName(userName);
    }


    public Date getBirthday() { return user.getUserBirthday(); }
    public void setBirthday(Date birthday) { user.setUserBirthday(birthday); }
    public String getSex() { return user.getUserSex(); }
    public void setSex(String sex) { user.setUserSex(sex); }
    public String getAddress() { return user.getUserAddress(); }
    public void setAddress(String address) { user.setUserAddress(address); }
}



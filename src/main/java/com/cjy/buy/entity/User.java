package com.cjy.buy.entity;


import java.time.LocalDateTime;
import java.io.Serializable;



/**
 * <p>
 * 
 * </p>
 *
 * @author cjy
 * @since 2019-01-25
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;   

   private Integer id;
    /**
     * 用户名
     */
   private String username;
    /**
     * 昵称
     */
   private String name;
    /**
     * 密码
     */
   private String password;
    /**
     * 加密密码的盐
     */
   private String salt;
    /**
     * 头像
     */
   private String userface;
    /**
     * 备注
     */
   private String remark;
    /**
     * 创建时间
     */
   private LocalDateTime createTime;
    /**
     * 电话
     */
   private String telephone;
    /**
     * 地址
     */
   private String address;
    /**
     * 用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
     */
   private Integer state;


   public  Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public  String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public  String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public  String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public  String getSalt() {
      return salt;
   }

   public void setSalt(String salt) {
      this.salt = salt;
   }

   public  String getUserface() {
      return userface;
   }

   public void setUserface(String userface) {
      this.userface = userface;
   }

   public  String getRemark() {
      return remark;
   }

   public void setRemark(String remark) {
      this.remark = remark;
   }

   public  LocalDateTime getCreateTime() {
      return createTime;
   }

   public void setCreateTime(LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public  String getTelephone() {
      return telephone;
   }

   public void setTelephone(String telephone) {
      this.telephone = telephone;
   }

   public  String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public  Integer getState() {
      return state;
   }

   public void setState(Integer state) {
      this.state = state;
   }


   @Override
   public String toString() {
      return "User{" +
         "id=" + id +
         ", username=" + username +
         ", name=" + name +
         ", password=" + password +
         ", salt=" + salt +
         ", userface=" + userface +
         ", remark=" + remark +
         ", createTime=" + createTime +
         ", telephone=" + telephone +
         ", address=" + address +
         ", state=" + state +
         "}";
   }
}
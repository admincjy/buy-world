package com.cjy.buy.entity;


import java.io.Serializable;



/**
 * <p>
 * 
 * </p>
 *
 * @author cjy
 * @since 2019-01-25
 */
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;   

   private Integer id;
    /**
     * 角色标识程序中判断使用,如"admin",这个是唯一的
     */
   private String role;
    /**
     * 角色描述,UI界面显示使用
     */
   private String description;
    /**
     * 是否可用,如果不可用将不会添加给用户
     */
   private Boolean available;


   public  Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public  String getRole() {
      return role;
   }

   public void setRole(String role) {
      this.role = role;
   }

   public  String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public  Boolean getAvailable() {
      return available;
   }

   public void setAvailable(Boolean available) {
      this.available = available;
   }


   @Override
   public String toString() {
      return "Role{" +
         "id=" + id +
         ", role=" + role +
         ", description=" + description +
         ", available=" + available +
         "}";
   }
}
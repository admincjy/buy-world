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
public class MenuRole implements Serializable {

    private static final long serialVersionUID = 1L;   

   private Integer id;
   private Integer menuId;
   private Integer roleId;


   public  Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public  Integer getMenuId() {
      return menuId;
   }

   public void setMenuId(Integer menuId) {
      this.menuId = menuId;
   }

   public  Integer getRoleId() {
      return roleId;
   }

   public void setRoleId(Integer roleId) {
      this.roleId = roleId;
   }


   @Override
   public String toString() {
      return "MenuRole{" +
         "id=" + id +
         ", menuId=" + menuId +
         ", roleId=" + roleId +
         "}";
   }
}
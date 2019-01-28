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
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;   

   private Integer id;
    /**
     * 全路径
     */
   private String url;
    /**
     * 路径
     */
   private String path;
    /**
     * 模块名称
     */
   private String component;
    /**
     * 名称
     */
   private String name;
    /**
     * 图标
     */
   private String iconCls;
   private Boolean keepAlive;
    /**
     * 是否需要身份验证
     */
   private Boolean requireAuth;
    /**
     * 父ID
     */
   private Integer parentId;
    /**
     * 是否可用
     */
   private Boolean available;
    /**
     * 父编号列表
     */
   private String parentIds;
    /**
     * 资源类型
     */
   private String resourceType;
    /**
     * 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     */
   private String permission;


   public  Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public  String getUrl() {
      return url;
   }

   public void setUrl(String url) {
      this.url = url;
   }

   public  String getPath() {
      return path;
   }

   public void setPath(String path) {
      this.path = path;
   }

   public  String getComponent() {
      return component;
   }

   public void setComponent(String component) {
      this.component = component;
   }

   public  String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public  String getIconCls() {
      return iconCls;
   }

   public void setIconCls(String iconCls) {
      this.iconCls = iconCls;
   }

   public  Boolean getKeepAlive() {
      return keepAlive;
   }

   public void setKeepAlive(Boolean keepAlive) {
      this.keepAlive = keepAlive;
   }

   public  Boolean getRequireAuth() {
      return requireAuth;
   }

   public void setRequireAuth(Boolean requireAuth) {
      this.requireAuth = requireAuth;
   }

   public  Integer getParentId() {
      return parentId;
   }

   public void setParentId(Integer parentId) {
      this.parentId = parentId;
   }

   public  Boolean getAvailable() {
      return available;
   }

   public void setAvailable(Boolean available) {
      this.available = available;
   }

   public  String getParentIds() {
      return parentIds;
   }

   public void setParentIds(String parentIds) {
      this.parentIds = parentIds;
   }

   public  String getResourceType() {
      return resourceType;
   }

   public void setResourceType(String resourceType) {
      this.resourceType = resourceType;
   }

   public  String getPermission() {
      return permission;
   }

   public void setPermission(String permission) {
      this.permission = permission;
   }


   @Override
   public String toString() {
      return "Menu{" +
         "id=" + id +
         ", url=" + url +
         ", path=" + path +
         ", component=" + component +
         ", name=" + name +
         ", iconCls=" + iconCls +
         ", keepAlive=" + keepAlive +
         ", requireAuth=" + requireAuth +
         ", parentId=" + parentId +
         ", available=" + available +
         ", parentIds=" + parentIds +
         ", resourceType=" + resourceType +
         ", permission=" + permission +
         "}";
   }
}
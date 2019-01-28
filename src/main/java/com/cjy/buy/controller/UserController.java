package com.cjy.buy.controller;

import com.cjy.buy.common.BaseRespData;
import com.cjy.buy.common.BaseRespMsg;
import com.cjy.buy.common.PageInfoReqVo;
import com.cjy.buy.entity.User;
import com.cjy.buy.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cjy
 * @since 2019-01-25
 */
@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService targetService;

    
    /**
     * 获取分页数据列表
     */
    @RequestMapping("/list")
	public BaseRespData list(@RequestBody PageInfoReqVo<User> pageInfoReqVo){
    	BaseRespData baseRespData=targetService.selectByPage(pageInfoReqVo);
		return baseRespData;
	}


    /**
     * 获取全部数据
     */
    @RequestMapping("/selectList")
    public BaseRespData findAll(){
        List<User> entitys = targetService.selectList();
        BaseRespData baseRespData=new BaseRespData();
        baseRespData.setAaData(entitys);
        baseRespData.setStaus(0);
        return baseRespData;
    }


    /**
     * 根据ID查找数据
     */
    @RequestMapping("/queryById")
    public BaseRespData find(@RequestParam("id") Long id){
        User entity = targetService.selectById(id);
        BaseRespData baseRespData=new BaseRespData();
        baseRespData.setObData(entity);
        baseRespData.setStaus(0);
        return baseRespData;
    }


    /**
     * 添加数据
     */
    @RequestMapping(value = "/insert")
    public BaseRespMsg addItem(@RequestBody User entity){
        int isOk = targetService.insert(entity);
        if(isOk==1){
            return new BaseRespMsg(0,"添加成功");
        }
        return BaseRespMsg.error("添加失败");
    }
    
    /**
     * 批量添加数据
     */
    @RequestMapping(value = "/batchSave")
    public BaseRespMsg batchSave(List<User> entitys){
        int isOk = targetService.batchSave(entitys);
        if(isOk>0){
            return new BaseRespMsg(0,"添加成功");
        }
        return BaseRespMsg.error("添加失败");
    }


    /**
     * 更新数据
     */
    @RequestMapping(value = "/update")
    public BaseRespMsg update(@RequestBody User entity){
        int isOk = targetService.update(entity);
        if(isOk==1){
            return new BaseRespMsg(0,"更新成功");
        }
        return BaseRespMsg.error("更新失败");
     }
     
     /**
     * 批量更新数据
     */
    @RequestMapping(value = "/batchUpdate")
    public BaseRespMsg batchUpdate(List<User> entitys){
        int isOk = targetService.batchUpdate(entitys);
        if(isOk>0){
            return new BaseRespMsg(0,"更新成功");
        }
        return BaseRespMsg.error("更新失败");
    }


    /**
     * 批量删除数据
     */
    @RequestMapping("/dels")
    public BaseRespMsg deleteItems(@RequestParam("ids") List<Long> ids){
        int isOk = targetService.deleteBatchIds(ids);
        if(isOk>0){
            return new BaseRespMsg(0,"批量删除成功");
        }
        return BaseRespMsg.error("批量删除失败");
    }
    
    /**
     * 删除数据
     */
    @RequestMapping("/del")
    public BaseRespMsg deleteItems(@RequestParam("id") Long id){
        int isOk = targetService.deleteById(id);
        if(isOk==1){
            return new BaseRespMsg(0,"删除成功");
        }
        return BaseRespMsg.error("删除失败");
    }

    /*
     * 登陆
     */
    @RequestMapping("/login")
    public BaseRespMsg login(String username,String password,boolean rememberMe){
        //把前端输入的username和password封装为token
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        new BaseRespMsg();
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            token.setRememberMe(rememberMe);
            subject.login(token);
            System.out.println("是否登录:"+subject.isAuthenticated());
            System.out.println("用户权限是否有VIP权限:"+subject.hasRole("vip"));
            return new BaseRespMsg(0,"登陆成功");
        } catch (IncorrectCredentialsException ice) {
            // 捕获密码错误异常
            return BaseRespMsg.error("登陆失败"+ ice.getMessage());
        } catch (UnknownAccountException uae) {
            // 捕获未知用户名异常
            return BaseRespMsg.error("登陆失败"+ "未知用户名异常");
        } catch (Exception eae) {
            // 捕获其他异常
            return BaseRespMsg.error("登陆失败"+ eae.getMessage());
        }

    }
    /*
     * 注册
     */
    @RequestMapping("/addUser")
    public BaseRespMsg addUser(String username,String password){
        User user=new User();
        user.setUsername(username);
        user.setPassword(this.makePasswordHasSalt(username,password).toString());
        user.setState(0);
        user.setSalt(username);
        int isOk = targetService.insert(user);
        if(isOk==1){
            return new BaseRespMsg(0,"添加成功");
        }
        return BaseRespMsg.error("添加失败");
    }

    public Object  makePasswordHasSalt(String username,String password){
        ByteSource salt = ByteSource.Util.bytes(username);
        Object result = new SimpleHash("MD5",password,salt,1);
        return  result;
    }


    /*
     * 注销
     */
    @RequestMapping("/loginout")
    public BaseRespMsg loginout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new BaseRespMsg(0,"已注销");
    }


    /**
     * 查权限
     */
    @RequiresRoles("vip")
    @RequestMapping(value = "/hasRole", method = RequestMethod.GET)
    @ResponseBody
    public BaseRespMsg hasRole(){

        return new BaseRespMsg(0,"有VIP才能访问这个路径");
    }


    
  }
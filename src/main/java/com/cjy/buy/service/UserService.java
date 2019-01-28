package com.cjy.buy.service;

import com.cjy.buy.common.BaseRespData;
import com.cjy.buy.common.PageInfoReqVo;
import com.cjy.buy.entity.User;
import com.cjy.buy.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cjy
 * @since 2019-01-25
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service
@Transactional
public class UserService{

    @Autowired
    private UserMapper targetMapper;
    
    /**
     * 获取分页数据列表
     */
    public BaseRespData selectByPage(PageInfoReqVo<User> pageInfoReqVo){
		PageHelper.startPage(pageInfoReqVo.getPage(), pageInfoReqVo.getSize());
		List<User> eList=targetMapper.selectByPage(pageInfoReqVo);
		PageInfo<User> pageDataList = new PageInfo<>(eList);
		BaseRespData baseRespData=new BaseRespData();
		baseRespData.setAaData(pageDataList.getList());
		baseRespData.setStaus(0);
		baseRespData.setDataCount(pageDataList.getTotal());
    	return baseRespData;
    }
    
    
    /**
     * 获取全部数据
     */
    public List<User> selectList(){
        List<User> entitys = targetMapper.selectList();
        return entitys;
    }


    /**
     * 根据ID查找数据
     */
    public User selectById(Long id){
        User entity = targetMapper.selectById(id);
        return entity;
    }


    /**
     * 添加数据
     */
    public int insert(User entity){
        int isOk = targetMapper.insert(entity);
        return isOk;
    }
    
     /**
     * 批量添加数据
     */
    public int batchSave(List<User> entitys){
        int isOk = targetMapper.batchSave(entitys);
        return isOk;
    }


    /**
     * 更新数据
     */
    public int update(User entity){
        int isOk = targetMapper.update(entity);
        return isOk;
     }
     
     /**
     * 批量更新数据
     */
    public int batchUpdate(List<User> entitys){
        int isOk = targetMapper.batchUpdate(entitys);
        return isOk;
    }
    
    /**
     * 删除数据
     */
    public int deleteById(Long id){
        int isOk = targetMapper.deleteById(id);
        return isOk;
    }

    /**
     * 批量删除数据
     */
    public int deleteBatchIds(List<Long> ids){
        int isOk = targetMapper.deleteBatchIds(ids);
        return isOk;
    }



    /*
     * 根据用户名查找user
     */
    public User findByUsername(String username){
        return targetMapper.findByUsername(username);
    }

    /*
     * 根据用户名查找密码
     */
    public String selectByUsername(String username){
        return targetMapper.selectByUsername(username);
    }

    /**
     * 根据用户名查找user角色
     *
     */
    public Set<String> findRoles(String username){
        return targetMapper.findRoles(username);
    }

    /**
     * 根据用户名查找user权限
     *
     */
    public Set<String> findPermissions(String username){
        return targetMapper.findPermissions(username);
    }




}


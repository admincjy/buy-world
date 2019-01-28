package com.cjy.buy.service;

import com.cjy.buy.common.BaseRespData;
import com.cjy.buy.common.PageInfoReqVo;
import com.cjy.buy.entity.UserRole;
import com.cjy.buy.mapper.UserRoleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
public class UserRoleService{

    @Autowired
    private UserRoleMapper targetMapper;
    
    /**
     * 获取分页数据列表
     */
    public BaseRespData selectByPage(PageInfoReqVo<UserRole> pageInfoReqVo){
		PageHelper.startPage(pageInfoReqVo.getPage(), pageInfoReqVo.getSize());
		List<UserRole> eList=targetMapper.selectByPage(pageInfoReqVo);
		PageInfo<UserRole> pageDataList = new PageInfo<>(eList);
		BaseRespData baseRespData=new BaseRespData();
		baseRespData.setAaData(pageDataList.getList());
		baseRespData.setStaus(0);
		baseRespData.setDataCount(pageDataList.getTotal());
    	return baseRespData;
    }
    
    
    /**
     * 获取全部数据
     */
    public List<UserRole> selectList(){
        List<UserRole> entitys = targetMapper.selectList();
        return entitys;
    }


    /**
     * 根据ID查找数据
     */
    public UserRole selectById(Long id){
        UserRole entity = targetMapper.selectById(id);
        return entity;
    }


    /**
     * 添加数据
     */
    public int insert(UserRole entity){
        int isOk = targetMapper.insert(entity);
        return isOk;
    }
    
     /**
     * 批量添加数据
     */
    public int batchSave(List<UserRole> entitys){
        int isOk = targetMapper.batchSave(entitys);
        return isOk;
    }


    /**
     * 更新数据
     */
    public int update(UserRole entity){
        int isOk = targetMapper.update(entity);
        return isOk;
     }
     
     /**
     * 批量更新数据
     */
    public int batchUpdate(List<UserRole> entitys){
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
    
    

}


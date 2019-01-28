package com.cjy.buy.service;

import com.cjy.buy.entity.Menu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.cjy.buy.mapper.MenuMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.cjy.buy.common.BaseRespData;
import com.cjy.buy.common.PageInfoReqVo;

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
public class MenuService{

    @Autowired
    private MenuMapper targetMapper;
    
    /**
     * 获取分页数据列表
     */
    public BaseRespData selectByPage(PageInfoReqVo<Menu> pageInfoReqVo){
		PageHelper.startPage(pageInfoReqVo.getPage(), pageInfoReqVo.getSize());
		List<Menu> eList=targetMapper.selectByPage(pageInfoReqVo);
		PageInfo<Menu> pageDataList = new PageInfo<>(eList);
		BaseRespData baseRespData=new BaseRespData();
		baseRespData.setAaData(pageDataList.getList());
		baseRespData.setStaus(0);
		baseRespData.setDataCount(pageDataList.getTotal());
    	return baseRespData;
    }
    
    
    /**
     * 获取全部数据
     */
    public List<Menu> selectList(){
        List<Menu> entitys = targetMapper.selectList();
        return entitys;
    }


    /**
     * 根据ID查找数据
     */
    public Menu selectById(Long id){
        Menu entity = targetMapper.selectById(id);
        return entity;
    }


    /**
     * 添加数据
     */
    public int insert(Menu entity){
        int isOk = targetMapper.insert(entity);
        return isOk;
    }
    
     /**
     * 批量添加数据
     */
    public int batchSave(List<Menu> entitys){
        int isOk = targetMapper.batchSave(entitys);
        return isOk;
    }


    /**
     * 更新数据
     */
    public int update(Menu entity){
        int isOk = targetMapper.update(entity);
        return isOk;
     }
     
     /**
     * 批量更新数据
     */
    public int batchUpdate(List<Menu> entitys){
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


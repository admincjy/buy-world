package com.cjy.buy.mapper;

import com.cjy.buy.entity.MenuRole;
import com.cjy.buy.common.PageInfoReqVo;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cjy
 * @since 2019-01-25
 */
public interface MenuRoleMapper{

       List<MenuRole> selectList();
       
       MenuRole selectById(Long id);
       
       int insert(MenuRole entity);
       
       int batchSave(List<MenuRole> entitys);
       
       int update(MenuRole entity);
       
       int batchUpdate(List<MenuRole> entitys);
       
       int deleteById(Long id);
       
       int deleteBatchIds(List<Long> ids);
       
       List<MenuRole> selectByPage(PageInfoReqVo<MenuRole> pageInfoReqVo);

}

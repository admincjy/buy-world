package com.cjy.buy.mapper;

import com.cjy.buy.entity.Role;
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
public interface RoleMapper{

       List<Role> selectList();
       
       Role selectById(Long id);
       
       int insert(Role entity);
       
       int batchSave(List<Role> entitys);
       
       int update(Role entity);
       
       int batchUpdate(List<Role> entitys);
       
       int deleteById(Long id);
       
       int deleteBatchIds(List<Long> ids);
       
       List<Role> selectByPage(PageInfoReqVo<Role> pageInfoReqVo);

}

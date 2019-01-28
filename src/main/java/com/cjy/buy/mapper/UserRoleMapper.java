package com.cjy.buy.mapper;

import com.cjy.buy.entity.UserRole;
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
public interface UserRoleMapper{

       List<UserRole> selectList();
       
       UserRole selectById(Long id);
       
       int insert(UserRole entity);
       
       int batchSave(List<UserRole> entitys);
       
       int update(UserRole entity);
       
       int batchUpdate(List<UserRole> entitys);
       
       int deleteById(Long id);
       
       int deleteBatchIds(List<Long> ids);
       
       List<UserRole> selectByPage(PageInfoReqVo<UserRole> pageInfoReqVo);

}

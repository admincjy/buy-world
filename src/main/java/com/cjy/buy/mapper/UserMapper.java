package com.cjy.buy.mapper;

import com.cjy.buy.common.PageInfoReqVo;
import com.cjy.buy.entity.User;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cjy
 * @since 2019-01-25
 */
public interface UserMapper{

       List<User> selectList();
       
       User selectById(Long id);
       
       int insert(User entity);
       
       int batchSave(List<User> entitys);
       
       int update(User entity);
       
       int batchUpdate(List<User> entitys);
       
       int deleteById(Long id);
       
       int deleteBatchIds(List<Long> ids);
       
       List<User> selectByPage(PageInfoReqVo<User> pageInfoReqVo);

       User findByUsername(String username);

       Set<String> findRoles(String username);

       Set<String> findPermissions(String username);

       String selectByUsername(String username);

}

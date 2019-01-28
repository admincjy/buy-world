package com.cjy.buy.mapper;

import com.cjy.buy.entity.Menu;
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
public interface MenuMapper{

       List<Menu> selectList();
       
       Menu selectById(Long id);
       
       int insert(Menu entity);
       
       int batchSave(List<Menu> entitys);
       
       int update(Menu entity);
       
       int batchUpdate(List<Menu> entitys);
       
       int deleteById(Long id);
       
       int deleteBatchIds(List<Long> ids);
       
       List<Menu> selectByPage(PageInfoReqVo<Menu> pageInfoReqVo);

}

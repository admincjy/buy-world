package com.cjy.buy.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cjy.buy.service.MenuService;
import com.cjy.buy.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cjy.buy.common.BaseRespData;
import com.cjy.buy.common.BaseRespMsg;
import com.cjy.buy.common.PageInfoReqVo;

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
@RequestMapping("Menu")
public class MenuController {


    @Autowired
    private MenuService targetService;

    
    /**
     * 获取分页数据列表
     */
    @RequestMapping("/list")
	public BaseRespData list(@RequestBody PageInfoReqVo<Menu> pageInfoReqVo){
    	BaseRespData baseRespData=targetService.selectByPage(pageInfoReqVo);
		return baseRespData;
	}


    /**
     * 获取全部数据
     */
    @RequestMapping("/selectList")
    public BaseRespData findAll(){
        List<Menu> entitys = targetService.selectList();
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
        Menu entity = targetService.selectById(id);
        BaseRespData baseRespData=new BaseRespData();
        baseRespData.setObData(entity);
        baseRespData.setStaus(0);
        return baseRespData;
    }


    /**
     * 添加数据
     */
    @RequestMapping(value = "/insert")
    public BaseRespMsg addItem(@RequestBody Menu entity){
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
    public BaseRespMsg batchSave(List<Menu> entitys){
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
    public BaseRespMsg update(@RequestBody Menu entity){
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
    public BaseRespMsg batchUpdate(List<Menu> entitys){
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
    
  }
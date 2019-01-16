package com.hqw.demo.controller;

import com.hqw.demo.config.DqProperties;
import com.hqw.demo.dao.result.Result;
import com.hqw.demo.dao.dqEntity.DqEntity;
import com.hqw.demo.dao.result.ResultUtils;
import com.hqw.demo.exception.DqException;
import com.hqw.demo.service.IDqService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DqController {

    @Resource
    private IDqService iDqServiceImpl;
    @Resource
    private DqProperties dqProperties;

    /**
     * 获取列表
     * @return
     */
    @GetMapping("/dqs")
    public List<DqEntity> getAllDqs(){
        return iDqServiceImpl.findAllDqs();
    }

    /**
     * 获取指定数据
     * @param id
     * @return
     */
    @GetMapping("/dqs/{id}")
    public Object getOneDq(@PathVariable("id") Integer id){
        Optional<?> optional =  iDqServiceImpl.findDqById(id);
        return optional.orElse(null);
    }

    /**
     * 更新一条数据
     * @param id
     */
    @PutMapping("/dqs/{id}")
    public void updateDqById(@PathVariable("id") Integer id){
        iDqServiceImpl.updateDqById(id, dqProperties.getName());
    }

    /**
     * 添加一条数据
     * @param dqEntity
     */
    @PostMapping("/dqs")
    public Result<DqEntity> addDq(@Valid DqEntity dqEntity, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtils.failedresult(bindingResult.getFieldError().getDefaultMessage(),0);
        }else {
            dqEntity.setBirth(dqEntity.getBirth());
            dqEntity.setCountry(dqEntity.getCountry());
            dqEntity.setName(dqEntity.getName());

            return ResultUtils.successResult(iDqServiceImpl.addDq(dqEntity));
        }
    }

    /**
     * 删除一条数据
     * @param id
     */
    @DeleteMapping("/dqs/{id}")
    public void deleteDq(@PathVariable("id") Integer id){
        iDqServiceImpl.deleteDqById(id);
    }

    /**
     * 获取分页信息
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/dqs/{page}/{size}")
    public List<DqEntity> getDqByPage(@PathVariable("page") Integer page,@PathVariable("size") int size){

        Sort sort = new Sort(Sort.Direction.ASC,"id");
        Pageable pageable = new PageRequest(page,size,sort);
        return iDqServiceImpl.getDqByPage(pageable);
    }

    /**
     * 联表查询
     * @return
     */
    @GetMapping("/dqs/type")
    public List<Object> getDqList(){
        return iDqServiceImpl.findDqList();
    }

    /**
     *
     * @return
     */
    @GetMapping("/dqs/two")
    public List<DqEntity> addTwoDq(){
        List<DqEntity> list = new ArrayList<>();
        list = iDqServiceImpl.addTwoDq();
        return list;
    }

    /**
     * 根据Dq信息中的birth判断阶段
     * @param id
     * @throws Exception
     */
    @GetMapping("/dqs/info/{id}")
    public void getInfoById(@PathVariable Integer id) throws DqException {
        iDqServiceImpl.getInfoById(id);
    }

}

package com.hqw.demo.service;

import com.hqw.demo.dao.IDqDao;
import com.hqw.demo.dao.dqEntity.DqEntity;
import com.hqw.demo.dao.result.Result;
import com.hqw.demo.exception.DqException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IDqService {

    public List<DqEntity> findAllDqs();

    public Optional<DqEntity> findDqById(Integer id);

    public DqEntity addDq(DqEntity dqEntity);

    public void deleteDqById(Integer id);

    public void updateDqById(Integer id,String country);

    public List<DqEntity> getDqByPage(Pageable pageable);

    public List<Object> findDqList();

    public List<DqEntity> addTwoDq();

    public void getInfoById (Integer id) throws DqException;


}

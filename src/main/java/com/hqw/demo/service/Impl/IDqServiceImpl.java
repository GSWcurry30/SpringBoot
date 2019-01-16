package com.hqw.demo.service.Impl;
import com.hqw.demo.dao.IDqDao;
import com.hqw.demo.dao.dqEntity.DqEntity;
import com.hqw.demo.dao.result.Result;
import com.hqw.demo.exception.DqException;
import com.hqw.demo.exception.ExceptionEnum;
import com.hqw.demo.service.IDqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IDqServiceImpl implements IDqService {

    @Autowired
    private IDqDao iDqDao;
    @Override
    public List<DqEntity> findAllDqs() {
        return iDqDao.findAll();
    }

    @Override
    public Optional<DqEntity> findDqById(Integer id) {
        return iDqDao.findById(id);
    }

    @Override
    public DqEntity addDq(DqEntity dqEntity) {
        return iDqDao.save(dqEntity);
    }

    @Override
    public void deleteDqById(Integer id) {
        iDqDao.deleteById(id);
    }
    @Override
    public void updateDqById(Integer id, String country){
        iDqDao.setDqCountry(id,country);
    }
    @Override
    public List<DqEntity> getDqByPage(Pageable pageable){
        return iDqDao.findAll(pageable).getContent();
    }
    @Override
    public List<Object> findDqList(){
        return iDqDao.findDqList();
    }
    @Override
    @Transactional
    public List<DqEntity> addTwoDq(){

        List<DqEntity> list = new ArrayList<>();
        DqEntity dqEntity1 = new DqEntity();
        dqEntity1.setName("mmm");
        dqEntity1.setCountry("ccc");
        dqEntity1.setBirth(1999);
        list.add(iDqDao.save(dqEntity1));

        DqEntity dqEntity2 = new DqEntity();
        dqEntity2.setName("ggg");
        dqEntity2.setCountry("sss");
        dqEntity2.setBirth(1996);
        list.add(iDqDao.save(dqEntity2));

        return list;
    }

    @Override
    public void getInfoById(Integer id) throws DqException {
        DqEntity dqEntity = iDqDao.findById(id).orElse(null);

        Integer bir = dqEntity.getBirth();

        if(bir > 2000)
        {
            throw new DqException(ExceptionEnum.PRIMARY_SCHOOL);
        }else if(bir <= 2000 && bir > 1900){
            throw new DqException(ExceptionEnum.MIDELE_SCHOOL);
        }else{
            throw new DqException(ExceptionEnum.HIGH_SCHOOL);
        }
    }
}
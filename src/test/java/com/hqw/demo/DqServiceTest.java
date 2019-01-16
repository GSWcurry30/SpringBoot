package com.hqw.demo;

import com.hqw.demo.dao.dqEntity.DqEntity;
import com.hqw.demo.service.IDqService;
import com.hqw.demo.service.Impl.IDqServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DqServiceTest {

    @Autowired
    private IDqService iDqService;

    @Test
    public void findDqByIdTest(){
        DqEntity dqEntity = iDqService.findDqById(14).get();
        Assert.assertEquals(new Integer(1991),dqEntity.getBirth());
    }
}

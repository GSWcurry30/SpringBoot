package com.hqw.demo.dao;

import com.hqw.demo.dao.dqEntity.DqEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDqDao extends JpaRepository<DqEntity, Integer> {

    @Query("update DqEntity as d set d.country=?2 where d.id=?1")
    @Modifying
    public void setDqCountry(Integer id,String country);

    @Query(value = "select d.*,t.class from dq d left join typedq t on d.name = t.name",nativeQuery = true)
    public List<Object> findDqList();
}

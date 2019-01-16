package com.hqw.demo.dao.dqEntity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
@Table(name = "dq")
@Data
public class DqEntity implements Serializable {

    private static final long serialVersionUID = -6550777752269466791L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String country;

    @Min(value = 1995,message = "小于1995")
    private Integer birth;

    public DqEntity(){}
}

package com.zack.model.enity.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class BaseEnity implements Serializable {
    private Long id;
    private Date createTime;
    private Date updateTime;
    private Integer isDeleted;
}

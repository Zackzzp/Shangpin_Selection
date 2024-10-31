package com.zack.model.enity.product;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.zack.model.enity.base.BaseEntity;
import lombok.Data;

@Data
public class ProductUnit extends BaseEntity {
   private String name;
}

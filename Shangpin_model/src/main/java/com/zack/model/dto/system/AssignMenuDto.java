package com.zack.model.dto.system;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class AssignMenuDto {
    private Long id;
    private List<Map<String, Number>> menuIdList;
}
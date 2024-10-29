package com.zack.manager.mapper;

import com.zack.model.enity.product.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /**
     * 按父节点查询
     * @return
     */
    public abstract List<Category> selectByParentId(Long parentId);

    /**
     * 按父节点计数
     * @param id
     * @return
     */
    public abstract int countByParentId(Long id);

    public abstract List<Category> selectAll();

    public abstract int batchInsert(List<Category> categoryList);
}

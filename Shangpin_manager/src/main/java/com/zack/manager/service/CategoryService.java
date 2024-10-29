package com.zack.manager.service;

import com.zack.model.enity.product.Category;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CategoryService {
    /**
     * 查询所有父级节点
     * @param parentId
     * @return
     */
    public abstract List<Category> findByParentId(Long parentId);

    /**
     * 导出数据
     * @param response
     */
    public abstract void exportData(HttpServletResponse response);

    /**
     * 导入数据
     * @param file
     */
    public abstract void importData(MultipartFile file);
}

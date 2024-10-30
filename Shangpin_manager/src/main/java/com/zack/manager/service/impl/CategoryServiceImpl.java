package com.zack.manager.service.impl;

import com.alibaba.excel.EasyExcel;
import com.zack.manager.Listener.CategoryListener;
import com.zack.manager.mapper.CategoryMapper;
import com.zack.manager.service.CategoryService;
import com.zack.model.enity.product.Category;
import com.zack.model.vo.product.CategoryExcelVo;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> findByParentId(Long parentId) {
        // 根据分类id查询它下面的所有的子分类数据
        List<Category> categoryList = categoryMapper.selectByParentId(parentId);
        if (!CollectionUtils.isEmpty(categoryList)) {

            // 遍历分类的集合，获取每一个分类数据
            categoryList.forEach(item -> {

                // 查询该分类下子分类的数量
                int count = categoryMapper.countByParentId(item.getId());
                if (count > 0) {
                    item.setHasChildren(true);
                } else {
                    item.setHasChildren(false);
                }

            });
        }
        return categoryList;
    }

    @Override
    public void exportData(HttpServletResponse response) {
        try {

            // 设置响应结果类型
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");

            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("分类数据", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");

            // 查询数据库中的数据
            List<Category> categoryList = categoryMapper.selectAll();
            List<CategoryExcelVo> categoryExcelVoList = new ArrayList<>(categoryList.size());

            // 将从数据库中查询到的Category对象转换成CategoryExcelVo对象
            for (Category category : categoryList) {
                CategoryExcelVo categoryExcelVo = new CategoryExcelVo();
                BeanUtils.copyProperties(category, categoryExcelVo, CategoryExcelVo.class);
                categoryExcelVoList.add(categoryExcelVo);
            }

            // 写出数据到浏览器端
            EasyExcel.write(response.getOutputStream(), CategoryExcelVo.class).sheet("分类数据").doWrite(categoryExcelVoList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    @Override
    public void importData(MultipartFile file) {
        InputStream inputStream = file.getInputStream();
        EasyExcel.read(inputStream, CategoryExcelVo.class,new CategoryListener()).sheet("分类数据").doRead();

    }
}
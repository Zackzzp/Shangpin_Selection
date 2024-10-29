package com.zack.manager.Listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.zack.model.vo.product.CategoryExcelVo;

import java.util.ArrayList;
import java.util.List;

public class CategoryListener extends AnalysisEventListener<CategoryExcelVo> {
List<CategoryExcelVo> list = new ArrayList<CategoryExcelVo>();
    @Override
    public void invoke(CategoryExcelVo categoryExcelVo, AnalysisContext analysisContext) {
        list.add(categoryExcelVo);
        if (list.size()>=10) {
            list.clear();
        }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}

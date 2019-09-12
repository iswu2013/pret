package com.pret.common.util;

import com.pret.common.vo.SortCondition;

import java.util.ArrayList;
import java.util.List;

/**
 * 排序帮助类
 */
public class SortConditionUtil {
    /**
     * 构建排序
     *
     * @param props
     * @return
     */
    public static List<SortCondition> build(String... props) {
        List<SortCondition> sortConditionList = new ArrayList<>();

        SortCondition sortCondition = new SortCondition();
        int i = 0;
        for (String prop : props) {
            if (i % 2 == 0) {
                sortCondition = new SortCondition();
                sortCondition.setDirection(prop);
            } else {
                sortCondition.setProperty(prop);
                sortConditionList.add(sortCondition);
            }
            i++;
        }

        return sortConditionList;
    }
}

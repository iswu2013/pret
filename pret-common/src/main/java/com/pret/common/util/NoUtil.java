package com.pret.common.util;

import com.pret.common.constant.ConstantEnum;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class NoUtil {
    public static String genNo(String type) {
        String no = StringUtils.EMPTY;

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date date = new Date();
        String dateStr = format.format(date);

        if (type.equals(ConstantEnum.NoTypeEnum.TH.name())) {
            return ConstantEnum.NoTypeEnum.TH.name().concat(dateStr);
        }

        return no;
    }
}

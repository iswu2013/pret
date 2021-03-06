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

        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        Date date = new Date();
        String dateStr = format.format(date);

        if (type.equals(ConstantEnum.NoTypeEnum.P.name())) {
            return ConstantEnum.NoTypeEnum.P.name().concat(dateStr);
        } else if(type.equals(ConstantEnum.NoTypeEnum.T.name())) {

            return ConstantEnum.NoTypeEnum.T.name().concat(dateStr);
        }else if(type.equals(ConstantEnum.NoTypeEnum.TR.name())) {
            return ConstantEnum.NoTypeEnum.TR.name().concat(dateStr);
        }else if(type.equals(ConstantEnum.NoTypeEnum.EX.name())) {
            return ConstantEnum.NoTypeEnum.EX.name().concat(dateStr);
        }

        return no;
    }
}

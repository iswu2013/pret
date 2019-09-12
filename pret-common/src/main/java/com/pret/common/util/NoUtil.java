package com.pret.common.util;

import com.pret.common.constant.ConstantEnum;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class NoUtil {
    /* *
     * 功能描述: 生成订单号
     * 〈〉
     * @Param: [type]
     * @Return: java.lang.String
     * @Author: jswul
     * @Date: 2019/7/13  13:49
     */
    public static String genNo(String type) {
        String no = StringUtils.EMPTY;

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date date = new Date();
        String dateStr = format.format(date);

        if (type.equals(ConstantEnum.NoTypeEnum.TX.name())) {
            return ConstantEnum.NoTypeEnum.TX.name().concat(dateStr);
        } else if (type.equals(ConstantEnum.NoTypeEnum.FO.name())) {
            return ConstantEnum.NoTypeEnum.FO.name().concat(dateStr);
        } else if (type.equals(ConstantEnum.NoTypeEnum.SO.name())) {
            return ConstantEnum.NoTypeEnum.SO.name().concat(dateStr);
        } else if (type.equals(ConstantEnum.NoTypeEnum.UO.name())) {
            return ConstantEnum.NoTypeEnum.UO.name().concat(dateStr);
        } else if (type.equals(ConstantEnum.NoTypeEnum.UC.name())) {
            return ConstantEnum.NoTypeEnum.UC.name().concat(dateStr);
        } else if (type.equals(ConstantEnum.NoTypeEnum.RE.name())) {
            return ConstantEnum.NoTypeEnum.RE.name().concat(dateStr);
        } else if (type.equals(ConstantEnum.NoTypeEnum.ZZ.name())) {
            return ConstantEnum.NoTypeEnum.ZZ.name().concat(dateStr);
        }

        return no;
    }

    /* *
     * 功能描述: 获取订单类别
     * 〈〉
     * @Param: [orderNo]
     * @Return: java.lang.String
     * @Author: jswul
     * @Date: 2019/7/13  13:48
     */
    public static int getOrderType(String orderNo) {
        if (orderNo.startsWith(ConstantEnum.NoTypeEnum.FO.name())) {
            return ConstantEnum.EOrderType.美食.getValue();
        } else if (orderNo.startsWith(ConstantEnum.NoTypeEnum.SO.name())) {
            return ConstantEnum.EOrderType.商超.getValue();
        } else if (orderNo.startsWith(ConstantEnum.NoTypeEnum.UO.name())) {
            return ConstantEnum.EOrderType.二手.getValue();
        } else if (orderNo.startsWith(ConstantEnum.NoTypeEnum.UC.name())) {
            return ConstantEnum.EOrderType.租房.getValue();
        } else if (orderNo.startsWith(ConstantEnum.NoTypeEnum.ZZ.name())) {
            return ConstantEnum.EOrderType.转帐.getValue();
        }

        return ConstantEnum.EOrderType.充值.getValue();
    }

    /* *
     * 功能描述: 获取订单类别
     * 〈〉
     * @Param: [orderNo]
     * @Return: java.lang.String
     * @Author: jswul
     * @Date: 2019/7/13  14:12
     */
    public static String getOrderTypeStr(String orderNo, String lang) {
        if (orderNo.startsWith(ConstantEnum.NoTypeEnum.FO.name())) {
            if (lang.equals(ConstantEnum.ELangType.cn.name())) {
                return ConstantEnum.EOrderType.美食.name();
            } else {
                return ConstantEnum.EOrderTypeEn.Food.name();
            }
        } else if (orderNo.startsWith(ConstantEnum.NoTypeEnum.SO.name())) {
            if (lang.equals(ConstantEnum.ELangType.cn.name())) {
                return ConstantEnum.EOrderType.商超.name();
            } else {
                return ConstantEnum.EOrderTypeEn.Supermarket.name();
            }
        } else if (orderNo.startsWith(ConstantEnum.NoTypeEnum.UO.name())) {
            if (lang.equals(ConstantEnum.ELangType.cn.name())) {
                return ConstantEnum.EOrderType.二手.name();
            } else {
                return ConstantEnum.EOrderTypeEn.used.name();
            }
        } else if (orderNo.startsWith(ConstantEnum.NoTypeEnum.UC.name())) {
            if (lang.equals(ConstantEnum.ELangType.cn.name())) {
                return ConstantEnum.EOrderType.租房.name();
            } else {
                return ConstantEnum.EOrderTypeEn.rent.name();
            }
        } else {
            if (lang.equals(ConstantEnum.ELangType.cn.name())) {
                return ConstantEnum.EOrderType.充值.name();
            } else {
                return ConstantEnum.EOrderTypeEn.recharge.name();
            }
        }
    }
}

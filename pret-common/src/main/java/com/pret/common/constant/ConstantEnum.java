package com.pret.common.constant;

/**
 * 常量美剧
 */
public class ConstantEnum {
    /**
     * 实体状态
     */
    public enum S {
        /**
         * 省
         */
        N(1),
        /**
         * 市
         */
        D(0);

        S(int label) {
            this.setLabel(label);
        }

        private int label;

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    /**
     * ParterApplyStatus
     * 查询类别
     */
    public enum QueryType {
        /**
         * 等于equal
         */
        eq$,
        /**
         * 不等于not equal
         */
        neq$,
        /**
         * 模糊查询 like
         */
        l$,
        /**
         * 多个条件模糊查询
         */
        ll$,
        /**
         * 模糊查询 not like
         */
        nl$,
        /**
         * in
         */
        in$,
        /**
         * not in
         */
        nin$,
        /**
         * between
         */
        bw$,
        /**
         * greaterThan
         */
        gt$,
        /**
         * greater than Or equal to
         */
        gte$,
        /**
         * less than
         */
        lt$,
        /**
         * less than or equal to
         */
        lte$,
        /**
         * 类似多个值
         */
        lm$
    }

    /**
     * 查询字段类型
     */
    public enum QueryGenericType {
        /**
         * String
         */
        String("class java.lang.String"),

        ListString("java.lang.String"),
        /**
         * int
         */
        Int("int"),

        /**
         * Float
         */
        Float("float"),

        /**
         * Integer
         */
        Integer("java.lang.Integer"),

        /**
         * Long
         */
        Long("long"),
        /**
         * boolean
         */
        bool("boolean"),
        /**
         * Boolean
         */
        Boolean("class java.lang.Boolean"),
        /**
         * Date
         */
        Date("class java.util.Date"),
        /**
         * List
         */
        List("interface java.util.List");

        private QueryGenericType(String genericType) {
            this.genericType = genericType;
        }

        private String genericType;

        public String getGenericType() {
            return genericType;
        }

        public void setGenericType(String genericType) {
            this.genericType = genericType;
        }
    }

    /**
     * 需要转图片的文件类型
     *
     * @author wujinsong
     */
    public enum FileType {
        /**
         * word
         */
        doc,
        /**
         * word
         */
        docx,
        /**
         * pdf
         */
        pdf,
        /**
         * excel
         */
        xls,
        /**
         * excel
         */
        xlsx,
        /**
         * ppt
         */
        ppt,
        /**
         * ppt
         */
        pptx,
        /**
         * autocad
         */
        dwg,
        /**
         * txt文件
         */
        txt;

        public static boolean isIn(String fileType) {
            boolean isIn = false;

            try {
                if (FileType.valueOf(fileType) != null) {
                    return isIn = true;
                }
            } catch (Exception e) {
            }

            return isIn;
        }
    }


    /**
     * 状态
     */
    public enum StatusType {
        启用, 禁用
    }


    public enum RolesEnum {
        /**
         * 会员
         */
        member,
        admin
    }


    public enum EAppVersionStatus {
        启用(0), 未启用(1);

        private EAppVersionStatus(int value) {
            this.value = value;
        }

        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public enum EAvType {
        安卓(0), 苹果(1);

        private EAvType(int value) {
            this.value = value;
        }

        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public enum EStatus {
        正常(0), 下架(1);

        private EStatus(int value) {
            this.value = value;
        }

        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /* *
     * 功能描述: 状态
     * 〈〉
     * @Param:
     * @Return:
     * @Author: wujingsong
     * @Date: 2019-08-18  17:45
     */
    public enum ECreditCardStatus {
        正常(1), 删除(0);

        private ECreditCardStatus(int value) {
            this.value = value;
        }

        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public enum ERecommend {
        默认(0), 推荐(1);

        private ERecommend(int value) {
            this.value = value;
        }

        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * 登录类别
     */
    public enum ELoginType {
        普通账号(0), fb(1), wechat(2), qq(3), google(4), twitter(5), whatsapp(6), instagram(7);

        private ELoginType(int value) {
            this.value = value;
        }

        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /* *
     * 功能描述: <br>
     * 〈〉订单状态
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/6/20  23:02
     */
    public enum EOrderStatus {
        未支付(0), 已支付(1), 退款(2), 已取消(4), 已完成(5);

        private EOrderStatus(int value) {
            this.value = value;
        }

        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /* *
     * 功能描述: 运输状态
     * 〈〉
     * @Param:
     * @Return:
     * @Author: wujingsong
     * @Date: 2019/9/20  8:40 下午
     */
    public enum ETransPlanStatus {
        运输中(0), 已签收(1), 退款(2), 已取消(4), 已完成(5);

        private ETransPlanStatus(int value) {
            this.value = value;
        }

        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public enum NoTypeEnum {
        /**
         * 提货计划
         */
        TH(0),
        /**
         * 运输计划
         */
        T(1),
        /**
         * 运输费用
         */
        R(2),
        /**
         * 异常单
         */
        EX(3),
        /**
         * 二维码
         */
        QR(4);
        private int label;

        private NoTypeEnum(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    /* *
     * 功能描述: 费用状态
     * 〈〉
     * @Param:
     * @Return:
     * @Author: wujingsong
     * @Date: 2019/10/4  3:22 下午
     */
    public enum EPretTransFeeStatus {
        待申报(0),
        已申报(1),
        通过(2),
        不通过(3);
        private int label;

        private EPretTransFeeStatus(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    /* *
     * 功能描述: 0待确认1已转u9
     * 〈〉
     * @Param:
     * @Return:
     * @Author: wujingsong
     * @Date: 2019/10/4  5:50 下午
     */
    public enum ETransStatementStatus {
        /**
         * 待确认
         */
        创建(0),
        /**
         * 已转U9
         */
        供应商已确认(1);
        private int label;

        ETransStatementStatus(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    public enum AreaLevelEnum {
        /**
         * 省
         */
        省(1),
        /**
         * 市
         */
        市(2),
        /**
         * 区或县
         */
        区县(3);
        private int label;

        private AreaLevelEnum(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    public enum EPretPickUpPlanStatus {
        待提货(1),
        已完成(2),
        已取消(3),
        部分完成(4);
        private int label;

        private EPretPickUpPlanStatus(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    /* *
     * 功能描述: 异常状态
     * 〈〉
     * @Param:
     * @Return:
     * @Author: wujingsong
     * @Date: 2019/10/19  6:46 上午
     */
    public enum ECheckStatus {
        待审核(0),
        通过(1),
        不通过(2);
        private int label;

        private ECheckStatus(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    /* *
     * 功能描述: 用户类型
     * 〈〉
     * @Param:
     * @Return:
     * @Author: wujingsong
     * @Date: 2019/10/19  9:43 下午
     */
    public enum EUserType {
        /**
         * 理货员
         */
        理货员(0),
        /**
         * 客户
         */
        客户(1),
        /**
         * 业务员
         */
        业务员(2),
        /**
         * 门卫
         */
        门卫(3),
        /**
         * 司机
         */
        司机(4),
        /**
         * 供应商
         */
        供应商(5),
        /**
         * 供应商子账号
         */
        供应商子账号(6),
        /**
         * 管理员
         */
        管理员(7);
        private int label;

        EUserType(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    /* *
     * 功能描述: 角色编码
     * 〈〉
     * @Param:
     * @Return:
     * @Author: wujingsong
     * @Date: 2019/10/20  9:05 下午
     */
    public enum ERoleCode {
        /**
         * 理货员
         */
        Tallylerk(0),
        /**
         * 客户
         */
        Customer(1),
        /**
         * 销售员
         */
        Salesman(2),
        /**
         * 门卫
         */
        Guard(3),
        /**
         * 司机
         */
        Driver(4),
        /**
         * 供应商
         */
        Vender(5);
        private int label;

        ERoleCode(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    /**
     * 全省/全市/全区县唯一标识
     */
    public enum AddressEnum {
        /**
         * 全省
         */
        全省("1"),
        /**
         * 全市
         */
        全市("2"),
        /**
         * 全区县
         */
        全区县("3");
        String value;

        AddressEnum(String value) {
            this.setValue(value);
        }

        //省略getter、setter方法

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    /* *
     * 功能描述: 费用类型
     * 〈〉
     * @Param:
     * @Return:
     * @Author: wujingsong
     * @Date: 2019/10/24  10:10 上午
     */
    public enum ECostType {
        量(0),
        票(1);
        private int label;

        ECostType(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    /* *
     * 功能描述: 订单统计类别
     * 〈〉
     * @Param:
     * @Return:
     * @Author: wujingsong
     * @Date: 2019/10/24  7:16 下午
     */
    public enum ETransOrderStatisticsUserType {
        平台(0),
        物流供应商(1);
        private int label;

        ETransOrderStatisticsUserType(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    /* *
     * 功能描述: 日期类别
     * 〈〉
     * @Param:
     * @Return:
     * @Author: wujingsong
     * @Date: 2019/10/24  7:26 下午
     */
    public enum EDateType {
        日(0),
        周(1),
        月(2),
        年(3);
        private int label;

        EDateType(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    /* *
     * 功能描述: 商品类别
     * 〈〉
     * @Param:
     * @Return:
     * @Author: wujingsong
     * @Date: 2019/10/27  11:14 上午
     */
    public enum EGoodsType {
        重货(0),
        泡货(1);
        private int label;

        EGoodsType(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    /* *
     * 功能描述: 运输单状态
     * 〈〉
     * @Param:
     * @Return:
     * @Author: wujingsong
     * @Date: 2019/10/27  5:37 下午
     */
    public enum ETransOrderStatus {
        待分配(0),
        待提货(1),
        已提货(2),
        运输中(3),
        已签收(4),
        已完成(5),
        提货中(6);
        private int label;

        ETransOrderStatus(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    /**
     * 单位1公斤2吨3立方米
     */
    public enum EUnit {
        公斤(1),
        吨(2),
        立方米(3);
        private int label;

        EUnit(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    /* *
     * 功能描述: 运输单类别
     * 〈〉
     * @Param:
     * @Return:
     * @Author: wujingsong
     * @Date: 2019/11/18  1:50 下午
     */
    public enum EPretTransPlanType {
        正常运输(0),
        退货运输(1);
        private int label;

        EPretTransPlanType(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    /* *
     * 功能描述: 数据来源
     * 〈〉
     * @Param:
     * @Return:
     * @Author: wujingsong
     * @Date: 2019/11/18  8:25 下午
     */
    public enum EDataSource {
        U9(1),
        OA(2);
        private int label;

        EDataSource(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    public enum EPretTransOrderType {
        非返程(0),
        返程配送单(1);
        private int label;

        EPretTransOrderType(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    /* *
     * 功能描述: 处理状态
     * 〈〉
     * @Param:
     * @Return:
     * @Author: wujingsong
     * @Date: 2019/11/19  5:37 下午
     */
    public enum EHandleStatus {
        待处理(0),
        待支付赔款(1),
        已付赔款(2),
        已结案(3);
        private int label;

        EHandleStatus(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法
        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    public enum EHandleDescription {
        自动结案(0),
        退货签收(1),
        赔款到账(2),
        微信截图(3),
        现场照片(4),
        责任认定(5);
        private int label;

        EHandleDescription(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法
        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    /* *
     * 功能描述: 异常处理方式
     * 〈〉
     * @Param:
     * @Return:
     * @Author: wujingsong
     * @Date: 2019/11/19  5:47 下午
     */
    public enum EHandleStyle {
        原路返回(0),
        罚款(1),
        其他(2);
        private int label;

        EHandleStyle(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法
        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param:
     * @Return:
     * @Author: wujingsong
     * @Date: 2019/11/23  2:07 下午
     */
    public enum ETransExceptionStatus {
        待认定(0),
        已认定(1),
        处理中(2),
        已结案(3);
        private int label;

        private ETransExceptionStatus(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    /**
     * 处理类型
     */
    public enum EHandleType {
        货主(1),
        物流(2);
        private int label;

        EHandleType(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param:
     * @Return:
     * @Author: wujingsong
     * @Date: 2019/11/26  12:55 上午
     */
    public enum EVenderType {
        三方(0),
        快递(1);
        private int label;
        EVenderType(int label) {
            this.setLabel(label);
        }

        //省略getter、setter方法
        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }
    }
}

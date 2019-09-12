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
         * 正常
         */
        N,
        /**
         * 删除ETranName
         */
        D,
        /**
         * 中间态
         */
        M
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
        正常(1),删除(0);

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
     * 〈〉 体现状态
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/6/20  17:04
     */
    public enum EPresentRecordStatus {
        处理中(0), 受理完毕(1), 失败(2), 异常(3);

        private EPresentRecordStatus(int value) {
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
     * 〈〉订单号开始
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/6/20  17:10
     */
    public enum EOrderNoStart {
        TX(0);

        private EOrderNoStart(int value) {
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
     * 〈〉订单类别
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/6/20  17:16
     */
    public enum NoTypeEnum {
        /**
         * 提现
         */
        TX(0),
        /**
         * 美食
         */
        FO(1),
        /**
         * 商超
         */
        SO(2),
        /**
         * 二手
         */
        UO(3),
        /**
         * 租房
         */
        UC(4),
        /**
         * 充值
         */
        RE(5),
        /**
         * 转账
         */
        ZZ(6),
        /**
         * 退款
         */
        TK(7);
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
     * 功能描述: <br>
     * 〈〉支付类别
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/6/20  18:29
     */
    public enum PayTypeEnum {
        /**
         * 未知
         */
        wz(0),
        /**
         * 微信支付
         */
        wx(1),
        /**
         * 支付宝支付
         */
        zfb(2),
        /**
         * 银联
         */
        yl(3),
        /**
         * 余额支付
         */
        ye(4),
        /**
         * worldpay
         */
        worldpay(5),
        /**
         * sage
         */
        sage(6);
        private int label;

        private PayTypeEnum(int label) {
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
     * 〈〉交易方向
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/6/20  22:02
     */
    public enum ETranDirection {
        进账("+"), 出账("-");

        private ETranDirection(String value) {
            this.value = value;
        }

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    /* *
     * 功能描述: <br>
     * 〈〉交易名称
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/6/20  22:03
     */
    public enum ETranName {
        用户转账(0), 出账(1), 进账(2);

        private ETranName(int value) {
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
     * 〈〉 订单评价状态
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/6/20  22:26
     */
    public enum EOrderEvaluateStatus {
        待审核(0), 正常(1), 删除(2);

        private EOrderEvaluateStatus(int value) {
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
     * 〈〉订单类别
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/6/20  22:48
     */
    public enum EOrderType {
        美食(0), 商超(1), 二手(2), 租房(3), 充值(4),转帐(5);

        private EOrderType(int value) {
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
     * 功能描述: 订单类别英文描述
     * 〈〉
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/7/13  14:16
     */
    public enum EOrderTypeEn {
        Food(0), Supermarket(1), used(2), rent(3), recharge(4);

        private EOrderTypeEn(int value) {
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
     * 〈〉商家确认状态
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/6/20  23:01
     */
    public enum EBusiStatus {
        已确认(0), 未确认(1);

        private EBusiStatus(int value) {
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
        未支付(0), 已支付(1), 退款(2), 已取消(4),已完成(5);

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
     * 功能描述: <br>
     * 〈〉订单类型
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/6/20  23:07
     */
    public enum EEOrderType {
        正常(0), 预订单(1);

        private EEOrderType(int value) {
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
     * 〈〉订单类别
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/6/20  23:08
     */
    public enum EOrderCategory {
        默认(0), 其他(1);

        private EOrderCategory(int value) {
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
     * 〈〉订单配送状态
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/6/20  23:08
     */
    public enum EOrderSendStatus {
        接单(1), 已送达(2);

        private EOrderSendStatus(int value) {
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
     * 功能描述: 租房合同付款狀態
     * 〈〉
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/6/22  10:12
     */
    public enum EUserContractPayStatus {
        未支付(0), 已支付(1), 退款(2), 已取消(4);

        private EUserContractPayStatus(int value) {
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
     * 功能描述: 用户类别
     * 〈〉
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/6/27  8:05
     */
    public enum EUserType {
        普通用户(0), 配送员(1);

        private EUserType(int value) {
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
     * 功能描述: 规则类型
     * 〈〉
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/6/27  8:20
     */
    public enum ERegularType {
        邀请注册("1"), 平台红包("2"), 商家红包("3"), 租房抵扣券("4");

        private ERegularType(String value) {
            this.value = value;
        }

        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    /* *
     * 功能描述: 优惠券状态
     * 〈〉
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/6/27  8:50
     */
    public enum ECpStatus {
        正常(0), 已使用(1), 失效(2), 删除(3);

        private ECpStatus(int value) {
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
     * 功能描述: 语言类别
     * 〈〉
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/6/27  18:44
     */
    public enum ELangType {
        cn, en
    }

    /**
     * 今天，明天枚举
     */
    public enum EDate {
        今天, Today, 明天, Tommorow
    }

    /* *
     * 功能描述: 午餐或晚餐类别
     * 〈〉
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/6/30  14:32
     */
    public enum EBusinessFoodGoodsType {
        午餐(0), 晚餐(1);

        private EBusinessFoodGoodsType(int value) {
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
     * 功能描述: 商品是否启用
     * 0不启用，1启用
     * 〈〉
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/7/3  17:55
     */
    public enum EIsStartDiscount {
        不启用(0), 启用(1);

        private EIsStartDiscount(int value) {
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
     * 功能描述: 购物车类别
     * 〈〉
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/7/3  19:26
     */
    public enum ECartType {
        美食(1), 商超(2), 二手(3);

        private ECartType(int value) {
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
     * 功能描述: 星期枚举
     * 〈〉
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/7/6  7:49
     */
    public enum EWeekday {
        星期一(1), 星期二(2), 星期三(3), 星期四(4), 星期五(5), 星期六(6), 星期日(0);

        private EWeekday(int value) {
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
     * 平台配置类别
     */
    public enum PlatformSetSetType {
        用户提现手续费(1), 企业对公账户信息(2), 微信支付付款汇率(3), 微信支付提现汇率(4), 美食配送时间设置(5), 商超配送时间设置(6), 二手配送时间设置(7),平台融云账户设置(8);

        private PlatformSetSetType(int value) {
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
     * 功能描述: 最早配送时间类别
     * 〈〉
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/7/11  18:50
     */
    public enum EEarliestDeliveryType {
        今天(0), 明天(1);

        private EEarliestDeliveryType(int value) {
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
     * 功能描述: 优惠券类别
     * 〈〉
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/7/13  20:42
     */
    public enum ECpType {
        通用券(0), 折扣券(1), 满减(2), 特定券(3), 兑换码(4);

        private ECpType(int value) {
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
     * 功能描述: 实体名称
     * 〈〉
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/7/16  18:30
     */
    public enum EntityEnum {
        BusinessFoodGoods,
        SupermarketGoods,
        UsedGoods,
        FoodOrderItems,
        User,
        Business,
        BusinessGoodsType
    }

    /* *
     * 功能描述: 支付状态
     * 〈〉
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/7/17  7:56
     */
    public enum EPayStatus {
        未支付(0), 已支付(1), 退款(2), 纠纷中(3), 已取消(4);

        private EPayStatus(int value) {
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
     * 功能描述: 申请状态
     * 0正常
     * 1确认中
     * 2确认
     * 3排除
     * 〈〉
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/7/19  11:44
     */
    public enum EParterApplyStatus {
        正常(0), 确认中(1), 确认(2), 排除(3);

        private EParterApplyStatus(int value) {
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
     * 功能描述: 中英文属性转换枚举
     * 〈〉
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/7/16  18:30
     */
    public enum LangEnum {

        // 美食
        igoodsName("BusinessFoodGoods", "igoodsName", "goodsName", "goodsEname"),
        igoodsDesc("BusinessFoodGoods", "igoodsDesc", "goodsDesc", "goodsEdesc"),

        // 商超
        igoodsNameS("SupermarketGoods", "igoodsName", "goodsName", "goodsEname"),
        igoodsDescS("SupermarketGoods", "igoodsDesc", "goodsDesc", "goodsEdesc"),
        isummary("SupermarketGoods", "isummary", "summary", "esummary"),

        // 二手
        igoodsNameU("UsedGoods", "igoodsName", "goodsName", "goodsEname"),
        igoodsDescU("UsedGoods", "igoodsDesc", "goodsDesc", "goodsEdesc"),
        iconditionDesc("UsedGoods", "iconditionDesc", "conditionDesc", "conditionEdesc"),

        // 美食明细
        iobjName("FoodOrderItems", "iobjName", "objName", "objEname"),

        // 商超明细
        iobjNameS("SupermarketOrderItems", "iobjName", "objName", "objEname"),


        // 业务用户
        ischool("User", "ischool", "school", "eschool"),

        // 商户
        ibusiName("Business", "ibusiName", "busiName", "busiEname"),
        ibusiDesc("Business", "ibusiDesc", "busiDesc", "busiEdesc"),
        isendTimeDesc("Business", "isendTimeDesc", "sendTimeDesc", "sendTimeEdesc"),
        ibusiAddress("Business", "ibusiAddress", "busiAddress", "busiAddress"),
        inoticeCont("Business", "inoticeCont", "noticeCont", "noticeEcont"),

        // 商品类别
        itypeName("BusinessGoodsType", "itypeName", "typeName", "typeEname"),

        ;


        LangEnum(String name, String target, String cn, String en) {
            this.name = name;
            this.target = target;
            this.cn = cn;
            this.en = en;
        }

        /**
         * 实体名
         */
        private String name;

        /**
         * 目标属性
         */
        private String target;
        /**
         * 中文
         */
        private String cn;
        /**
         * 英文
         */
        private String en;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getCn() {
            return cn;
        }

        public void setCn(String cn) {
            this.cn = cn;
        }

        public String getEn() {
            return en;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public static LangEnum[] getByName(String name) {
            int count = getCountByName(name);
            LangEnum[] ret = new LangEnum[count];
            int c = 0;

            LangEnum[] langEnums = LangEnum.values();
            for (LangEnum langEnum : langEnums) {
                if (name.equals(langEnum.getName())) {
                    ret[c] = langEnum;
                    c++;
                }
            }

            return langEnums;
        }


        public static int getCountByName(String name) {
            int count = 0;
            LangEnum[] langEnums = LangEnum.values();
            for (LangEnum langEnum : langEnums) {
                if (name.equals(langEnum.getName())) {
                    count++;
                }
            }
            return count;
        }
    }

    /* *
     * 功能描述: 上传路径分类
     * 〈〉
     * @Param:
     * @Return:
     * @Author: jswul
     * @Date: 2019/7/20  8:37
     */
    public enum UploadPahtEnum {
        /**
         * 头像
         */
        avatar,
        /**
         *
         */
        feedback,
        /**
         * 租房合同
         */
        contract
    }

    /* *
     * 功能描述: 链接类型
     * 〈〉
     * @Param:
            * @Return:
            * @Author: jswul
            * @Date: 2019/7/23  8:16
     */
    public enum ELinkType {
        隐私(0), 条款(1),faq(2),分享(3),下载(4),;

        ELinkType(int value) {
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
     * 功能描述: 体现用户类别
     * 〈〉
     * @Param:
            * @Return:
            * @Author: jswul
            * @Date: 2019/7/27  18:12
     */
    public enum EEUserType {
        app用户(0), 商户(1);

        private EEUserType(int value) {
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
     * 〈〉
     * @Param: 交易类别
            * @Return:
            * @Author: wujingsong
            * @Date: 2019-07-29  15:02
     */
    public enum  ETransactionDetailsType {
        转账(0), 其他(1);

        private ETransactionDetailsType(int value) {
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

    public enum  EClientType {
        App(0), Web(1);

        private EClientType(int value) {
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
     * 功能描述: 租房
     * 〈〉
     * @Param:
            * @Return:
            * @Author: wujingsong
            * @Date: 2019-08-03  15:36
     */
    public enum EUserContractStatus {
        正常(0), 到期(1);

        private EUserContractStatus(int value) {
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
     * 功能描述: 押金状态
     * 〈〉
     * @Param:
            * @Return:
            * @Author: wujingsong
            * @Date: 2019-08-03  17:51
     */
    public enum EPledgeStatus {
        正常(1), 已退(2);

        private EPledgeStatus(int value) {
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
     * 功能描述: 用户状态
     * 〈〉
     * @Param:
            * @Return:
            * @Author: wujingsong
            * @Date: 2019-08-04  14:02
     */
    public enum EUserStatus {
        正常(0), 禁用(1);

        private EUserStatus(int value) {
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
     * 功能描述: 取现类别
     * 〈〉
     * @Param:
            * @Return:
            * @Author: wujingsong
            * @Date: 2019-08-14  13:39
     */
    public enum EPresentType {
        支付宝(0), 微信(1);

        private EPresentType(int value) {
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
}

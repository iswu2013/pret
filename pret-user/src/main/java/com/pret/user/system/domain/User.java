package com.pret.user.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.converter.TimeConverter;
import com.pret.common.domain.RegexpConstant;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_user")
@Excel("用户信息表")
public class User implements Serializable {

    private static final long serialVersionUID = -4852732617765810959L;
    /**
     * 账户状态
     */
    public static final String STATUS_VALID = "1";

    public static final String STATUS_LOCK = "0";

    public static final String DEFAULT_AVATAR = "default.jpg";

    /**
     * 性别
     */
    public static final String SEX_MALE = "0";

    public static final String SEX_FEMALE = "1";

    public static final String SEX_UNKNOW = "2";

    // 默认密码
    public static final String DEFAULT_PASSWORD = "admin1";

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    @Size(min = 4, max = 20, message = "{range}")
    @ExcelField(value = "用户名")
    private String username;

    private String password;

    private String deptId;

    @ExcelField(value = "部门")
    private transient String deptName;

    @Size(max = 50, message = "{noMoreThan}")
    @Email(message = "{email}")
    @ExcelField(value = "邮箱")
    private String email;

    @Pattern(regexp = RegexpConstant.MOBILE_REG, message = "{mobile}")
    @ExcelField(value = "手机号")
    private String mobile;

    @NotBlank(message = "{required}")
    @ExcelField(value = "状态", writeConverterExp = "0=锁定,1=有效")
    private String status;

    @ExcelField(value = "创建时间", writeConverter = TimeConverter.class)
    private Date createTime;

    private Date modifyTime;

    @ExcelField(value = "最后登录时间", writeConverter = TimeConverter.class)
    private Date lastLoginTime;

    @NotBlank(message = "{required}")
    @ExcelField(value = "性别", writeConverterExp = "0=男,1=女,2=保密")
    private String ssex;

    @Size(max = 100, message = "{noMoreThan}")
    @ExcelField(value = "个人描述")
    private String description;

    @ExcelField(value = "用户类型")
    private Integer userType;

    private String avatar;

    /**
     * 父id
     */
    private String parentId;

    /**
     * 供应商id
     */
    private String venderId;

    @NotBlank(message = "{required}")
    private transient String roleId;
    @ExcelField(value = "角色")
    private transient String roleName;

    /**
     * 用户姓名
     */
    private String name;

    private String u9code;

    /**
     * 审核状态
     */
    private Integer authStatus = ConstantEnum.EAuthStatus.待审核.getLabel();

    private String nickName;

    // 排序字段
    private transient String sortField;

    // 排序规则 ascend 升序 descend 降序
    private transient String sortOrder;

    private transient String createTimeFrom;
    private transient String createTimeTo;
    private transient Integer notUserType;
    private long createTimeLong;// 创建时间
    private String createTimeStr;
    private Date lastModifiedDate;// 最后修改时间

    /**
     * shiro-redis v3.1.0 必须要有 getAuthCacheKey()或者 getId()方法
     * # Principal id field name. The field which you can get unique id to identify this principal.
     * # For example, if you use UserInfo as Principal class, the id field maybe userId, userName, email, etc.
     * # Remember to add getter to this id field. For example, getUserId(), getUserName(), getEmail(), etc.
     * # Default value is authCacheKey or id, that means your principal object has a method called "getAuthCacheKey()" or "getId()"
     *
     * @return userId as Principal id field name
     */
    public String getAuthCacheKey() {
        return id;
    }
}

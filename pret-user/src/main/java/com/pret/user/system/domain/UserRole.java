package com.pret.user.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("t_user_role")
@Data
public class UserRole implements Serializable {

    private static final long serialVersionUID = -3166012934498268403L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    private String userId;

    private String roleId;
}
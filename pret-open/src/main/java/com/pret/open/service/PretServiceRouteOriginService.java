package com.pret.open.service;

import com.pret.api.vo.ResBody;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretServiceRouteOrigin;
import com.pret.open.entity.bo.PretServiceRouteOrginBo;
import com.pret.open.entity.vo.PretServiceRouteOrginVo;
import com.pret.open.repository.PretServiceRouteOriginRepository;
import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.open.vo.req.P8000010Vo;
import com.pret.open.vo.res.PR8000010Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Description: [pret服务]
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class PretServiceRouteOriginService extends BaseServiceImpl<PretServiceRouteOriginRepository, PretServiceRouteOrigin, PretServiceRouteOrginVo> {
    @Autowired
    private PretAddressService pretAddressService;

    /* *
     * 功能描述: 新增起运地
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/26  10:30 下午
     */
    public void serviceRouteOrginAdd(PretServiceRouteOrginBo bo) {
        PretServiceRouteOrigin item = new PretServiceRouteOrigin();
        BeanUtilsExtended.copyProperties(item, bo);
        item.setFullAddress(pretAddressService.getDetailByAddressId(item.getAddressId()) + item.getDetail());
        this.repository.save(item);
    }

    /* *
     * 功能描述: 获取提货工厂
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/12/11  11:20 上午
     */
    public ResBody getPretServiceRouteOrigin(P8000010Vo res) {
        PR8000010Vo retVo = new PR8000010Vo();

        List<PretServiceRouteOrigin> pretServiceRouteOriginList = this.repository.findByS(ConstantEnum.S.N.getLabel());
        retVo.setData(pretServiceRouteOriginList);

        return retVo;
    }
}

package com.pret.service.handler;

import java.util.List;

import com.pret.api.vo.ReqBody;
import com.pret.api.vo.ResBody;
import com.pret.api.filter.BaseContext;
import com.pret.vo.req.PPertSupplierDeleteVo;
import com.pret.api.handler.JopHandler;
import com.pret.service.PertSupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

/**
 * Description: [pert服务]
 * Created on 2019年08月29日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class HPertSupplierDelete extends BaseContext implements JopHandler{
    private static final Logger LOGGER = LoggerFactory.getLogger(HPertSupplierDelete.class);
    private static final String TAG = "HPertSupplierSave";
    @Autowired
    private PertSupplierService service;

    @Override
    public ResBody handle(ReqBody requestBody) {
        PPertSupplierDeleteVo res = (PPertSupplierDeleteVo) requestBody;
        return service.delete(res);
    }
}

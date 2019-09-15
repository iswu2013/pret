package com.pret.open.service.handler;

import com.pret.api.vo.ReqBody;
import com.pret.api.vo.ResBody;
import com.pret.api.filter.BaseContext;
import com.pret.open.vo.req.PPretAdressDeleteVo;
import com.pret.api.handler.JopHandler;
import com.pret.open.service.PretAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

/**
 * Description: [pret服务]
 * Created on 2019年09月15日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class HPretAdressDelete extends BaseContext implements JopHandler{
    private static final Logger LOGGER = LoggerFactory.getLogger(HPretAdressDelete.class);
    private static final String TAG = "HPretAdressSave";
    @Autowired
    private PretAddressService pretAdressService;

    @Override
    public ResBody handle(ReqBody requestBody) {
        PPretAdressDeleteVo res = (PPretAdressDeleteVo) requestBody;
        return pretAdressService.delete(res);
    }
}

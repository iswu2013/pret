package com.pret.open.service.handler;

import java.util.List;

import com.pret.api.vo.ReqBody;
import com.pret.api.vo.ResBody;
import com.pret.api.filter.BaseContext;
import com.pret.open.vo.req.PPretQuotationItemDeleteVo;
import com.pret.api.handler.JopHandler;
import com.pret.open.service.PretQuotationItemService;
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
public class HPretQuotationItemDelete extends BaseContext implements JopHandler{
    private static final Logger LOGGER = LoggerFactory.getLogger(HPretQuotationItemDelete.class);
    private static final String TAG = "HPretQuotationItemSave";
    @Autowired
    private PretQuotationItemService pretQuotationItemService;

    @Override
    public ResBody handle(ReqBody requestBody) {
        PPretQuotationItemDeleteVo res = (PPretQuotationItemDeleteVo) requestBody;
        return pretQuotationItemService.delete(res);
    }
}

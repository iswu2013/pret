package com.pret.open.service;

import com.google.common.reflect.TypeToken;
import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.common.constant.CommonConstants;
import com.pret.open.entity.PretTableItem;
import com.pret.open.entity.bo.PretTableBo;
import com.pret.open.entity.bo.PretTableItemBo;
import com.pret.open.entity.vo.PretTableItemVo;
import com.pret.open.repository.PretTableItemRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Description: [pluto服务]
 * Created on 2019年10月03日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class PretTableItemService extends BaseServiceImpl<PretTableItemRepository, PretTableItem, PretTableItemVo> {
    public void tableItemAdd(PretTableBo bo) {
        List<PretTableItem> tableItemList = this.repository.findByModule(bo.getModule());
        this.repository.deleteAll(tableItemList);

        List<PretTableItemBo> list = CommonConstants.GSON.fromJson(bo.getTableItemBoStr(),
                new TypeToken<List<PretTableItemBo>>() {
                }.getType());
        for (PretTableItemBo itemBo : list) {
            PretTableItem tableItem = new PretTableItem();
            tableItem.setModule(bo.getModule());
            tableItem.setTitle(itemBo.getTitle());
            tableItem.setDataIndex(itemBo.getDataIndex());
            this.repository.save(tableItem);
        }
    }
}

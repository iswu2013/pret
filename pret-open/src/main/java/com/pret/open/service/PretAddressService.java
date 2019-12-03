package com.pret.open.service;

import com.pret.api.vo.ResBody;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretAddress;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.vo.PretAddressVo;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretAddressRepository;
import com.pret.api.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
public class PretAddressService extends BaseServiceImpl<PretAddressRepository, PretAddress, PretAddressVo> {
    /* *
     * 功能描述: 根据addreddId查找
     * 〈〉
     * @Param: [addressId]
     * @Return: java.util.List<java.lang.String>
     * @Author: wujingsong
     * @Date: 2019/11/9  11:03 上午
     */
    public List<String> findAddressListByAddressId(String addressId) {
        List<String> addressIdList = new ArrayList<>();
        addressIdList.add(addressId);
        PretAddress pretAddress = this.repository.findById(addressId).get();
        if (pretAddress != null) {
            Optional<PretAddress> pretAddressOptional = this.repository.findById(pretAddress.getParentId());
            // 找到全市
            PretAddress address = this.repository.findByParentIdAndAdds(pretAddressOptional.get().getId(), 1);
            if (address != null) {
                addressIdList.add(address.getId());
            }
            if (pretAddressOptional.isPresent()) {
                addressIdList.add(pretAddressOptional.get().getId());
                if (!StringUtils.isEmpty(pretAddressOptional.get().getParentId())) {
                    addressIdList.add(pretAddressOptional.get().getParentId());
                    address = this.repository.findByParentIdAndAdds(pretAddressOptional.get().getParentId(), 1);
                    if (address != null) {
                        addressIdList.add(address.getId());
                    }
                }
            }
        }

        return addressIdList;
    }

    public List<String> findAddressListByAddressIdAdd(String addressId) {
        List<String> addressIdList = new ArrayList<>();
        addressIdList.add(addressId);
        PretAddress pretAddress = this.repository.findById(addressId).get();
        if (!StringUtils.isEmpty(pretAddress.getParentId())) {
            pretAddress = this.repository.findById(pretAddress.getParentId()).get();
            addressId = pretAddress.getId();
            if (!StringUtils.isEmpty(pretAddress.getParentId())) {
                pretAddress = this.repository.findById(pretAddress.getParentId()).get();
                addressId = pretAddress.getId();
            }
        }

        List<PretAddress> pretAddressList = this.repository.findByParentIdAndS(addressId, ConstantEnum.S.N.getLabel());
        if (pretAddressList != null && pretAddressList.size() > 0) {
            for (PretAddress address : pretAddressList) {
                if (!addressIdList.contains(address.getId())) {
                    addressIdList.add(address.getId());
                    pretAddressList = this.repository.findByParentIdAndS(address.getId(), ConstantEnum.S.N.getLabel());
                    if (pretAddressList != null && pretAddressList.size() > 0) {
                        for (PretAddress addr : pretAddressList) {
                            if (!addressIdList.contains(addr.getId())) {
                                addressIdList.add(addr.getId());
                            }
                        }
                    }
                }
            }
        }

        return addressIdList;
    }

    /* *
     * 功能描述: 获取详细地址
     * 〈〉
     * @Param: [addressId]
     * @Return: java.lang.String
     * @Author: wujingsong
     * @Date: 2019/11/14  8:00 下午
     */
    public String getDetailByAddressId(String addressId) {
        String detail = StringUtils.EMPTY;

        PretAddress pretAddress = this.repository.findById(addressId).get();
        detail += pretAddress.getName();
        if (!StringUtils.isEmpty(pretAddress.getParentId())) {
            pretAddress = this.repository.findById(pretAddress.getParentId()).get();
            detail = pretAddress.getName() + detail;
            if (!StringUtils.isEmpty(pretAddress.getParentId())) {
                pretAddress = this.repository.findById(pretAddress.getParentId()).get();
                detail = pretAddress.getName() + detail;
            }
        }

        return detail;
    }
}

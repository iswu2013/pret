package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretAddress;
import com.pret.open.entity.PretBillingIntervalItem;
import com.pret.open.entity.PretTransTrajectory;
import com.pret.open.entity.vo.PretTransTrajectoryVo;
import com.pret.open.repository.PretAddressRepository;
import com.pret.open.repository.PretTransTrajectoryRepository;
import com.pret.open.service.PretTransTrajectoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransTrajectory")
public class PretTransTrajectoryController extends BaseManageController<PretTransTrajectoryService, PretTransTrajectory, PretTransTrajectoryVo> {
    @Autowired
    private PretTransTrajectoryRepository pretTransTrajectoryRepository;
    @Autowired
    private PretAddressRepository pretAddressRepository;

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretTransTrajectory view(@PathVariable String id) throws FebsException {
        try {
            PretTransTrajectory item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    /* *
     * 功能描述: 根据运输计划查找
     * 〈〉
     * @Param: [id]
     * @Return: java.util.List<com.pret.open.entity.PretTransTrajectory>
     * @Author: wujingsong
     * @Date: 2019/11/3  8:33 上午
     */
    @RequestMapping(value = "/getByTransPlanId/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<PretTransTrajectory> getByTransPlanId(@PathVariable String id) {
        List<PretTransTrajectory> pretTransTrajectoryList = pretTransTrajectoryRepository.findByTransPlanIdAndS(id, ConstantEnum.S.N.getLabel());
        for (PretTransTrajectory pretTransTrajectory : pretTransTrajectoryList) {
            if (!StringUtils.isEmpty(pretTransTrajectory.getAddressId())) {
                StringBuilder sb = new StringBuilder();
                PretAddress pretAddress = pretAddressRepository.findById(pretTransTrajectory.getAddressId()).get();
                if(pretAddress != null) {
                    sb.append(pretAddress.getName());
                    if(!StringUtils.isEmpty(pretAddress.getParentId())) {
                        PretAddress address = pretAddressRepository.findById(pretAddress.getParentId()).get();
                        sb.insert(1,address.getName());
                        if(!StringUtils.isEmpty(address.getParentId())) {
                            sb.insert(1,address.getParentName());
                        }
                    }
                }
                pretTransTrajectory.setAddress(sb.toString() + pretTransTrajectory.getRemark());
            }

        }
        return pretTransTrajectoryList;
    }
}
package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretPickUpPlanBo;
import com.pret.open.entity.bo.PretPickUpPlanModifyDriverBo;
import com.pret.open.entity.vo.PretPickUpPlanVo;
import com.pret.open.repository.*;
import com.pret.open.service.PretPickUpPlanService;
import com.pret.open.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("pretPickUpPlan")
public class PretPickUpPlanController extends BaseManageController<PretPickUpPlanService, PretPickUpPlan, PretPickUpPlanVo> {
    @Autowired
    private PretTransOrderRepository pretTransOrderRepository;
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private PretDriverRepository pretDriverRepository;
    @Autowired
    private PretServiceRouteOriginRepository pretServiceRouteOriginRepository;
    @Autowired
    private PretCustomerRepository pretCustomerRepository;
    @Autowired
    private UserService userService;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretPickUpPlanVo request, PretPickUpPlan t) {
        if(!StringUtils.isEmpty(request.getUserId())) {
            request.setIn$deptId(userService.getDeptIdListByUserId(request.getUserId()));
        }
        Page<PretPickUpPlan> page = this.service.page(request);
        for (PretPickUpPlan pickUpPlan : page.getContent()) {
            List<PretTransOrder> transOrderList = pretTransOrderRepository.findByPickUpPlanIdAndS(pickUpPlan.getId(), ConstantEnum.S.N.getLabel());
            pickUpPlan.setTransOrderList(transOrderList);
            if (!StringUtils.isEmpty(pickUpPlan.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(pickUpPlan.getVenderId()).get();
                pickUpPlan.setPretVender(pretVender);
            }
            if (!StringUtils.isEmpty(pickUpPlan.getDriverId())) {
                PretDriver pretDriver = pretDriverRepository.findById(pickUpPlan.getDriverId()).get();
                pickUpPlan.setPretDriver(pretDriver);
            }
            if (!StringUtils.isEmpty(pickUpPlan.getServiceRouteOriginId())) {
                PretServiceRouteOrigin pretServiceRouteOrigin = pretServiceRouteOriginRepository.findById(pickUpPlan.getServiceRouteOriginId()).get();
                pickUpPlan.setPretServiceRouteOrigin(pretServiceRouteOrigin);
            }
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretPickUpPlan view(@PathVariable String id) throws FebsException {
        try {
            PretPickUpPlan item = this.service.findById(id).get();
            List<PretTransOrder> pretTransOrderList = pretTransOrderRepository.findByPickUpPlanIdAndS(item.getId(), ConstantEnum.S.N.getLabel());
            for (PretTransOrder pretTransOrder : pretTransOrderList) {
                PretCustomer pretCustomer = pretCustomerRepository.findById(pretTransOrder.getCustomerId()).get();
                pretTransOrder.setPretCustomer(pretCustomer);
            }
            item.setTransOrderList(pretTransOrderList);
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @Log("生成提货计划")
    @PostMapping("/pretPickUpPlanAdd")
    public void pretPickUpPlanAdd(PretPickUpPlanBo bo) throws FebsException {
        try {
            this.service.genPickUpPlan(bo);
        } catch (Exception e) {
            throw new FebsException(e.getMessage());
        }
    }

    @Log("取消提货计划")
    @PostMapping("/pretPickUpPlanCancel/{ids}")
    public void pretPickUpPlanCancel(@PathVariable String ids) throws FebsException {
        try {
            this.service.pretPickUpPlanCancel(ids);
        } catch (Exception e) {
            message = "删除失败";
            throw new FebsException(message);
        }
    }

    @Log("修改提货司机")
    @PostMapping("/pretModifyDriver")
    public void pretModifyDriver(PretPickUpPlanModifyDriverBo bo) throws FebsException {
        try {
            this.service.pretModifyDriver(bo);
        } catch (Exception e) {
            message = "修改司机失败";
            throw new FebsException(message);
        }
    }

    /* *
     * 功能描述: 下载二维码
     * 〈〉
     * @Param: []
     * @Return: org.springframework.http.ResponseEntity<org.springframework.core.io.InputStreamResource>
     * @Author: wujingsong
     * @Date: 2019/12/4  4:34 下午
     */
    @RequestMapping(value = "/downEwm/{id}")
    @ResponseBody
    public ResponseEntity<InputStreamResource> downEwm(@PathVariable String id) throws IOException {
        try {
            PretPickUpPlan pretPickUpPlan = this.service.findById(id).get();
            String fileName = pretPickUpPlan.getQrcode() + ".png";
            String fullPath = Constants.QR_ROOT_PATH + pretPickUpPlan.getQrcodePath();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", new String(fileName.getBytes("gb2312"), "iso-8859-1"));// new String("线上消费记录".getBytes("GBK"),"iso-8859-1")
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            File file = new File(fullPath);
            FileInputStream inputStream = new FileInputStream(file);

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(new InputStreamResource(inputStream));
        } catch (Exception e) {
            System.out.print("错误");
        } finally {
        }

        return null;
    }
}
package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.api.vo.LabelValue;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.msg.ListRestResponse;
import com.pret.open.entity.PretAddress;
import com.pret.open.entity.bo.PretAddressBo;
import com.pret.open.entity.vo.PretAddressVo;
import com.pret.open.repository.PretAddressRepository;
import com.pret.open.service.PretAddressService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 地址管理
 */
@Slf4j
@Validated
@RestController
@RequestMapping("pretAddress")
public class PretAddressController extends BaseManageController<PretAddressService, PretAddress, PretAddressVo> {
    @Autowired
    private PretAddressRepository pretAddressRepository;

    /* *
     * 功能描述: 查找全部地址
     * 〈〉
     * @Param: []
     * @Return: java.util.List<com.pret.open.entity.PretAddress>
     * @Author: wujingsong
     * @Date: 2019/10/14  12:02 上午
     */
    @GetMapping(value = "/getAll")
    public List<PretAddressBo> getAll() {
        List<PretAddressBo> pretAddressBoList = new ArrayList<>();

        List<PretAddress> pretAddressList = pretAddressRepository.findByLevels(1);
        for (PretAddress pretAddress : pretAddressList) {
            PretAddressBo pretAddressBo = new PretAddressBo();
            pretAddressBo.setFirstName(pretAddress.getName());
            List<PretAddress> addressList = pretAddressRepository.findByParentId(pretAddress.getId());
            for (PretAddress address : addressList) {
                PretAddressBo addressBo = new PretAddressBo();
                addressBo.setSecondName(address.getName());
                List<PretAddress> list = pretAddressRepository.findByParentId(address.getId());
                for (PretAddress addr : list) {
                    PretAddressBo bo = new PretAddressBo();
                    bo.setThirdName(addr.getName());
                    addressBo.getChildren().add(bo);
                }
                pretAddressBo.getChildren().add(addressBo);
            }

            pretAddressBoList.add(pretAddressBo);
        }

        return pretAddressBoList;
    }

    /* *
     * 功能描述: 获取省份
     * 〈〉
     * @Param: []
     * @Return: com.pret.common.msg.ListRestResponse<java.util.List<com.pret.api.vo.LabelValue>>
     * @Author: wujingsong
     * @Date: 2019/10/17  4:54 下午
     */
    @RequestMapping(value = "/getProvince", method = RequestMethod.GET)
    @ResponseBody
    public ListRestResponse<List<LabelValue>> getProvince() {
        ListRestResponse<List<LabelValue>> retVo = new ListRestResponse<>();
        List<PretAddress> areaList = this.pretAddressRepository.findByLevelsAndS(ConstantEnum.AreaLevelEnum.省.getLabel(), ConstantEnum.S.N.getLabel());
        List<LabelValue> labelValueList = new ArrayList<>();
        this.getLV(areaList, labelValueList, StringUtils.EMPTY, -1);
        retVo.setResult(labelValueList);

        return retVo;
    }

    /* *
     * 功能描述: 级别
     * 〈〉
     * @Param: [areaList, labelValueList]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/17  4:54 下午
     */
    private void getLV(List<PretAddress> areaList, List<LabelValue> labelValueList, String parentId, int levels) {
        // 如果是1，全省
//        if (levels == ConstantEnum.AreaLevelEnum.省.getLabel()) {
//            LabelValue labelValue = new LabelValue();
//            labelValue.setLabel(ConstantEnum.AddressEnum.全省.name());
//            labelValue.setValue(parentId + ConstantEnum.AddressEnum.全省.getValue());
//            labelValueList.add(labelValue);
//        } else if (levels == ConstantEnum.AreaLevelEnum.市.getLabel()) {
//            LabelValue labelValue = new LabelValue();
//            labelValue.setLabel(ConstantEnum.AddressEnum.全市.name());
//            labelValue.setValue(parentId + ConstantEnum.AddressEnum.全市.getValue());
//            labelValueList.add(labelValue);
//        } else if (levels == ConstantEnum.AreaLevelEnum.区县.getLabel()) {
//            LabelValue labelValue = new LabelValue();
//            labelValue.setLabel(ConstantEnum.AddressEnum.全区县.name());
//            labelValue.setValue(parentId + ConstantEnum.AddressEnum.全区县.getValue());
//            labelValueList.add(labelValue);
//        }

        for (PretAddress area : areaList) {
            LabelValue labelValue = new LabelValue();
            labelValue.setLabel(area.getName());
            labelValue.setValue(area.getId());
            if (area.getLevels() == ConstantEnum.AreaLevelEnum.市.getLabel()) {
                PretAddress pretAddress = pretAddressRepository.findById(area.getParentId()).get();
                labelValue.setProvince(pretAddress.getName());
            }
            if (area.getLevels() == ConstantEnum.AreaLevelEnum.区县.getLabel()) {
                PretAddress pretAddress = pretAddressRepository.findById(area.getParentId()).get();
                labelValue.setCity(pretAddress.getName());

                PretAddress address = pretAddressRepository.findById(pretAddress.getParentId()).get();
                labelValue.setProvince(address.getName());
            }

            labelValueList.add(labelValue);
        }
    }

    /* *
     * 功能描述: 根据父id获取
     * 〈〉
     * @Param: [id]
     * @Return: com.pret.common.msg.ListRestResponse<java.util.List<com.pret.api.vo.LabelValue>>
     * @Author: wujingsong
     * @Date: 2019/10/17  4:55 下午
     */
    @RequestMapping(value = "/getByParentId", method = RequestMethod.GET)
    @ResponseBody
    public ListRestResponse<List<LabelValue>> getByParentId(String id) {
        ListRestResponse<List<LabelValue>> retVo = new ListRestResponse<>();
        List<LabelValue> labelValueList = new ArrayList<>();
//        if (id.equals("1")) {
//            LabelValue labelValue = new LabelValue();
//            labelValue.setLabel(ConstantEnum.AddressEnum.全省.name());
//            labelValue.setValue(ConstantEnum.AddressEnum.全省.getValue());
//            labelValue.setProvince(ConstantEnum.AddressEnum.全省.getValue());
//            labelValueList.add(labelValue);
//
//            retVo.setResult(labelValueList);
//        } else {
//
//        }

        PretAddress pretAddress = pretAddressRepository.findById(id).get();
        if (pretAddress.getName().equals(ConstantEnum.AddressEnum.全省.name()) && pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.市.getLabel()) {
            PretAddress address = pretAddressRepository.findById(pretAddress.getParentId()).get();
            LabelValue labelValue = new LabelValue();
            labelValue.setLabel(pretAddress.getName());
            labelValue.setValue(pretAddress.getId());
            labelValue.setProvince(address.getName());
            labelValueList.add(labelValue);
        } else {
            List<PretAddress> areaList = pretAddressRepository.findByParentIdAndS(id, ConstantEnum.S.N.getLabel());
            this.getLV(areaList, labelValueList, id, pretAddress.getLevels());
        }

        retVo.setResult(labelValueList);

        return retVo;
    }
}
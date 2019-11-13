package com.pret.open.schedule;

import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.open.entity.*;
import com.pret.open.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author wujingsong
 * @title: ScheduleService
 * @projectName pret
 * @description: TODO
 * @date 2019/10/18:59 下午
 */
@Component()
public class ScheduleService {
    @Autowired
    private PretTransOrderRepository pretTransOrderRepository;
    @Autowired
    private PretCustomerRepository pretCustomerRepository;
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private PretGoodsRepository pretGoodsRepository;
    @Autowired
    private PretAddressRepository pretAddressRepository;
    private boolean hasExecute = false;

    //@Scheduled(cron = "0 */5 * * * ?")
    public void autoDeleteLunch() {
        for (int i = 0; i < 100; i++) {
            PretTransOrder pretTransOrder = new PretTransOrder();
            pretTransOrder.setCustomerAddress("上海市金山区朱泾镇红菱苑31号602" + i % 5);
            PretCustomer pretCustomer = new PretCustomer();
            pretCustomer.setName("客户" + i % 5);
            pretCustomer.setLinkName("客户" + i % 5);
            pretCustomer.setLinkPhone("1378777777" + i % 5);
            pretCustomerRepository.save(pretCustomer);
            pretTransOrder.setCustomerId(pretCustomer.getId());
            pretTransOrder.setCustomerLinkName("客户" + i % 5);
            pretTransOrder.setCustomerAddress("上海市金山区朱泾镇红菱苑31号602" + i % 5);
            pretTransOrder.setCustomerLinkPhone("1378777777" + i % 5);
            pretTransOrder.setDeliveryBillNumber("20191001" + i % 8);
            pretTransOrder.setDeliveryDate(new Date());
            pretTransOrder.setOrderNo(Constants.df_yyyyMMddHHmmssSSS.format(new Date()));
            pretTransOrder.setTakeDeliveryDate(new Date());
            pretTransOrder.setServiceRouteOriginId("SH-JX");
            pretTransOrder.setTransMode("陆运");

            PretVender pretVender = pretVenderRepository.findTop1ByOrderByCreateTimeLongDesc();
            pretTransOrder.setVenderId(pretVender.getId());
            pretTransOrder.setGw(Float.valueOf((i % 7)));

            PretGoods pretGoods = new PretGoods();
            pretGoods.setBatchNo("B100");
            pretGoods.setPartNo("P100");
            pretGoods.setProduct("平板电脑");
            pretGoods.setUnit(i % 2);
            pretGoodsRepository.save(pretGoods);

            pretTransOrder.setGoodsId(pretGoods.getId());
            pretTransOrder.setGoodsNum(i % 9);

            pretTransOrderRepository.save(pretTransOrder);
        }
    }

    // 加上全省全市
//    @Scheduled(cron = "0 */1 * * * ?")
    public void autoAddPretAddress() {
        if (!hasExecute) {
            this.hasExecute = true;
            List<PretAddress> pretAddressList = pretAddressRepository.findByLevels(ConstantEnum.AreaLevelEnum.省.getLabel());
            for (PretAddress pretAddress : pretAddressList) {
                PretAddress address = new PretAddress();
                address.setAdds(1);
                address.setLevels(ConstantEnum.AreaLevelEnum.市.getLabel());
                address.setParentId(pretAddress.getId());
                address.setParentName(address.getName());
                address.setName(ConstantEnum.AddressEnum.全省.name());
                address.setValue("P" + pretAddress.getValue());

                pretAddressRepository.save(address);
            }

            List<PretAddress> pretAddresses = pretAddressRepository.findByLevelsAndAdds(ConstantEnum.AreaLevelEnum.市.getLabel(), 0);
            for (PretAddress pretAddress : pretAddresses) {
                PretAddress address = new PretAddress();
                address.setAdds(1);
                address.setLevels(ConstantEnum.AreaLevelEnum.区县.getLabel());
                address.setParentId(pretAddress.getId());
                address.setParentName(address.getName());
                address.setName(ConstantEnum.AddressEnum.全市.name());
                address.setValue("C" + pretAddress.getValue());

                pretAddressRepository.save(address);
            }
        }
    }
}

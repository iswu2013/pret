package com.pret.open.schedule;

import com.pret.common.constant.Constants;
import com.pret.open.entity.PretCustomer;
import com.pret.open.entity.PretGoods;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.PretVender;
import com.pret.open.repository.PretCustomerRepository;
import com.pret.open.repository.PretGoodsRepository;
import com.pret.open.repository.PretTransOrderRepository;
import com.pret.open.repository.PretVenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

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

    //@Scheduled(cron = "0 */5 * * * ?")
    public void autoDeleteLunch() {
        for(int i = 0;i< 100;i++) {
            PretTransOrder pretTransOrder = new PretTransOrder();
            pretTransOrder.setCustomerAddress("上海市金山区朱泾镇红菱苑31号602"+i%5);
            PretCustomer pretCustomer = new PretCustomer();
            pretCustomer.setName("客户"+i%5);
            pretCustomer.setLinkName("客户"+i%5);
            pretCustomer.setLinkPhone("1378777777"+i%5);
            pretCustomerRepository.save(pretCustomer);
            pretTransOrder.setCustomerId(pretCustomer.getId());
            pretTransOrder.setCustomerLinkName("客户"+i%5);
            pretTransOrder.setCustomerAddress("上海市金山区朱泾镇红菱苑31号602"+i%5);
            pretTransOrder.setCustomerLinkPhone("1378777777"+i%5);
            pretTransOrder.setDeliveryBillNumber("20191001"+i%8);
            pretTransOrder.setDeliveryDate(new Date());
            pretTransOrder.setOrderNo(Constants.df_yyyyMMddHHmmssSSS.format(new Date()));
            pretTransOrder.setTakeDeliveryDate(new Date());
            pretTransOrder.setServiceRouteOrginId("SH-JX");
            pretTransOrder.setTransMode("陆运");

            PretVender pretVender = pretVenderRepository.findTop1ByOrderByCreateTimeLongDesc();
            pretTransOrder.setVenderId(pretVender.getId());
            pretTransOrder.setCount(i%7);

            PretGoods pretGoods = new PretGoods();
            pretGoods.setBatchNo("B100");
            pretGoods.setPartNo("P100");
            pretGoods.setProduct("平板电脑");
            pretGoods.setUnit(i%2);
            pretGoods.setWeight(String.valueOf(i%4));
            pretGoodsRepository.save(pretGoods);

            pretTransOrder.setGoodsId(pretGoods.getId());
            pretTransOrder.setCb(String.valueOf(i%9));

            pretTransOrderRepository.save(pretTransOrder);
        }
    }
}

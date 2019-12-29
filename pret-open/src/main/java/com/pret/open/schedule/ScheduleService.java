package com.pret.open.schedule;

import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.open.entity.*;
import com.pret.open.repository.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

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
    private PretAddressRepository pretAddressRepository;
    private boolean hasExecute = false;
    @Autowired
    private PretBaseProvinceRepository pretBaseProvinceRepository;
    @Autowired
    private PretBaseProvinceTrlRepository pretBaseProvinceTrlRepository;
    @Autowired
    private PretBaseCityRepository pretBaseCityRepository;
    @Autowired
    private PretBaseCityTrlRepository pretBaseCityTrlRepository;
    @Autowired
    private PretBaseCountyRepository pretBaseCountyRepository;
    @Autowired
    private PretBaseCountyTrlRepository pretBaseCountyTrlRepository;

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
            pretTransOrder.setTakeDeliveryDate(new Date());
            pretTransOrder.setServiceRouteOriginId("SH-JX");

            PretVender pretVender = new PretVender();
            pretTransOrder.setVenderId(pretVender.getId());
            pretTransOrder.setGw(Float.valueOf((i % 7)));
            pretTransOrder.setGoodsNum(i % 9);

            pretTransOrderRepository.save(pretTransOrder);
        }
    }

    // 加上全省全市
    //@Scheduled(cron = "0 */1 * * * ?")
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

    //@Scheduled(cron = "0 */1 * * * ?")
    public void getAdderss() {
        try {
            if (!hasExecute) {
                this.hasExecute = true;
                List<PretBaseProvince> pretBaseProvinceList = pretBaseProvinceRepository.findByCountry("1000703050000023");
                for (PretBaseProvince pretBaseProvince : pretBaseProvinceList) {
                    PretBaseProvinceTrl pretBaseProvinceTrl = pretBaseProvinceTrlRepository.findByIdAndSysmiflag(pretBaseProvince.getId(), "zh-CN");
                    PretAddress pretAddress = new PretAddress();
                    pretAddress.setValue(pretBaseProvince.getCode());
                    pretAddress.setId(pretBaseProvince.getId());
                    //pretAddress.setIds(pretBaseProvince.getId());
                    pretAddress.setName(pretBaseProvinceTrl.getName());
                    pretAddress.setLevels(ConstantEnum.AreaLevelEnum.省.getLabel());
                    pretAddress.setAdds(0);
                    pretAddressRepository.save(pretAddress);

                    List<PretBaseCity> pretBaseCityList = pretBaseCityRepository.findByProvince(pretBaseProvince.getId());
                    for (PretBaseCity pretBaseCity : pretBaseCityList) {
                        PretBaseCityTrl pretBaseCityTrl = pretBaseCityTrlRepository.findByIdAndSysmiflag(pretBaseCity.getId(), "zh-CN");
                        pretAddress = new PretAddress();
                        pretAddress.setValue(pretBaseCity.getCode());
                        pretAddress.setId(pretBaseCity.getId());
                        //pretAddress.setIds(pretBaseCity.getId());
                        pretAddress.setName(pretBaseCityTrl.getName());
                        pretAddress.setLevels(ConstantEnum.AreaLevelEnum.市.getLabel());
                        pretAddress.setParentName(pretBaseProvinceTrl.getName());
                        pretAddress.setParentId(pretBaseProvinceTrl.getId());
                        pretAddress.setAdds(0);
                        pretAddressRepository.save(pretAddress);

                        List<PretBaseCounty> pretBaseCountyList = pretBaseCountyRepository.findByCity(pretBaseCity.getId());
                        for (PretBaseCounty pretBaseCounty : pretBaseCountyList) {
                            PretBaseCountyTrl pretBaseCountyTrl = pretBaseCountyTrlRepository.findByIdAndSysmiflag(pretBaseCounty.getId(), "zh-CN");
                            pretAddress = new PretAddress();
                            pretAddress.setValue(pretBaseCounty.getCode());
                            pretAddress.setId(pretBaseCounty.getId());
                           // pretAddress.setIds(pretBaseCounty.getId());
                            pretAddress.setName(pretBaseCountyTrl.getName());
                            pretAddress.setLevels(ConstantEnum.AreaLevelEnum.区县.getLabel());
                            pretAddress.setParentName(pretBaseCityTrl.getName());
                            pretAddress.setParentId(pretBaseCityTrl.getId());
                            pretAddress.setAdds(0);
                            pretAddressRepository.save(pretAddress);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //@Scheduled(cron = "0 */1 * * * ?")
    public void inportData() {
        if (!hasExecute) {
            this.hasExecute = true;
            Map<String, List<String>> map = new HashMap<>();
            try {
                String filePath = "/Users/wujingsong/IdeaProjects/pret/pret-open/src/main/resources/p.xlsx";
                List<PretAddress> provinceList = new ArrayList<>();
                List<PretAddress> cityList = new ArrayList<>();
                List<PretAddress> areaList = new ArrayList<>();

                InputStream is = new FileInputStream(filePath);

                int index = filePath.lastIndexOf(".");
                String postfix = filePath.substring(index + 1);

                Workbook workbook = null;
                if ("xls".equals(postfix)) {
                    workbook = new HSSFWorkbook(is);
                } else if ("xlsx".equals(postfix)) {
                    workbook = new XSSFWorkbook(is);
                }
                //获取第1张表
                Sheet sheet = workbook.getSheetAt(1);
                //总的行数
                int rows = sheet.getLastRowNum();
                //总的列数--->最后一列为null则有问题，读取不完整，将表头的数目作为总的列数，没有的则补为null
                //先列后行
                for (int i = 1; i <= rows; i++) {
                    Row row = sheet.getRow(i);
                    if (null != row && row.getFirstCellNum() == -1) {//这一行是空行，不读取
                        continue;
                    }

                    String type = row.getCell(3).getStringCellValue();
                    if (type.equals("zh-CN")) {
                        PretAddress pretAddress = new PretAddress();
                        pretAddress.setLevels(ConstantEnum.AreaLevelEnum.省.getLabel());
                        if (row.getCell(0) != null) {
                            pretAddress.setId(row.getCell(0).getStringCellValue());
                        }
                        if (row.getCell(1) != null) {
                            pretAddress.setValue(row.getCell(1).getStringCellValue());
                        }
                        if (row.getCell(4) != null) {
                            pretAddress.setName(row.getCell(4).getStringCellValue());
                        }
                        provinceList.add(pretAddress);
                    }
                }
                pretAddressRepository.saveAll(provinceList);

                //获取第2张表
                Sheet sheet2 = workbook.getSheetAt(2);
                //总的行数
                rows = sheet2.getLastRowNum();
                //总的列数--->最后一列为null则有问题，读取不完整，将表头的数目作为总的列数，没有的则补为null
                //先列后行
                for (int i = 1; i <= rows; i++) {
                    Row row = sheet2.getRow(i);
                    if (null != row && row.getFirstCellNum() == -1) {//这一行是空行，不读取
                        continue;
                    }

                    String type = row.getCell(2).getStringCellValue();
                    if (type.equals("zh-CN")) {
                        PretAddress pretAddress = new PretAddress();
                        pretAddress.setLevels(ConstantEnum.AreaLevelEnum.市.getLabel());
                        if (row.getCell(0) != null) {
                            pretAddress.setId(row.getCell(0).getStringCellValue());
                        }
                        if (row.getCell(1) != null) {
                            pretAddress.setValue(row.getCell(1).getStringCellValue());
                        }
                        if (row.getCell(3) != null) {
                            pretAddress.setName(row.getCell(3).getStringCellValue());
                        }
                        if (row.getCell(4) != null) {
                            pretAddress.setParentId(row.getCell(4).getStringCellValue());
                        }
                        cityList.add(pretAddress);
                    }

                }
                System.out.println("城市");
                pretAddressRepository.saveAll(cityList);

                Sheet sheet3 = workbook.getSheetAt(3);
                //总的行数
                rows = sheet3.getLastRowNum();
                //总的列数--->最后一列为null则有问题，读取不完整，将表头的数目作为总的列数，没有的则补为null
                //先列后行
                for (int i = 1; i <= rows; i++) {
                    Row row = sheet3.getRow(i);
                    if (null != row && row.getFirstCellNum() == -1) {//这一行是空行，不读取
                        continue;
                    }
                    String type = row.getCell(2).getStringCellValue();
                    if (type.equals("zh-CN")) {
                        PretAddress pretAddress = new PretAddress();
                        pretAddress.setLevels(ConstantEnum.AreaLevelEnum.区县.getLabel());
                        if (row.getCell(0) != null) {
                            pretAddress.setId(row.getCell(0).getStringCellValue());
                        }
                        if (row.getCell(1) != null) {
                            pretAddress.setValue(row.getCell(1).getStringCellValue());
                        }
                        if (row.getCell(3) != null) {
                            pretAddress.setName(row.getCell(3).getStringCellValue());
                        }
                        if (row.getCell(4) != null) {
                            pretAddress.setParentId(row.getCell(4).getStringCellValue());
                        }

                        areaList.add(pretAddress);
                    }
                }
                System.out.println("区县");
                pretAddressRepository.saveAll(areaList);

                //遍历map集合，封装成bean
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

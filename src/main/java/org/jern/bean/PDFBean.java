package org.jern.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class PDFBean {
    // 订单号	订单日期	产品编号	产品说明	订货数量	商品/赠品	单位	未税单价	未税金额	金额(含税)	赠品金额
    @ExcelProperty(value = "订单号", index = 0)
    private String orderNo;
    @ExcelProperty(value = "订单日期", index = 1)
    private String orderDate;
    @ExcelProperty(value = "产品编号", index = 2)
    private String productNo;
    @ExcelProperty(value = "产品说明", index = 3)
    private String productDesc;
    @ExcelProperty(value = "订货数量", index = 4)
    private String orderNum;
    @ExcelProperty(value = "商品/赠品", index = 5)
    private String productType;
    @ExcelProperty(value = "单位", index = 6)
    private String unit;
    @ExcelProperty(value = "未税单价", index = 7)
    private String unitPrice;
    @ExcelProperty(value = "未税金额", index = 8)
    private String amount;
    @ExcelProperty(value = "金额(含税)", index = 9)
    private String amountTax;
    @ExcelProperty(value = "赠品金额", index = 10)
    private String giftAmount;
}

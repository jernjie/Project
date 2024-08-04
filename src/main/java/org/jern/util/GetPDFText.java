package org.jern.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.jern.bean.PDFBean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetPDFText {
    public static ArrayList<PDFBean> getPDFText(String pdfPath, String regex) throws IOException {
        // 1.打开文件
        File file = new File(pdfPath);
        PDDocument pdDocument = PDDocument.load(file);
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
        pdfTextStripper.setSortByPosition(true);
        // 2.读取pdf
        String text = pdfTextStripper.getText(pdDocument);
        // 3.正则匹配
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        // 4.分割字符串以提取每条记录
        String[] lines = text.split("\n");
        ArrayList<PDFBean> pdfBeans = new ArrayList<>();
        for (String line : lines) {
            // 创建Matcher对象
            Matcher matcher = pattern.matcher(line.trim());
            if (matcher.find()) {
                PDFBean pdfBean = new PDFBean();
                pdfBean.setOrderNo("");
                pdfBean.setOrderDate("");
                pdfBean.setProductNo(matcher.group(1));
                pdfBean.setProductDesc(matcher.group(2));
                pdfBean.setUnit(matcher.group(4));
                pdfBean.setOrderNum(matcher.group(3));
                pdfBean.setUnitPrice(matcher.group(5));
                pdfBean.setAmount(matcher.group(6));
                pdfBean.setAmountTax("");
                pdfBean.setGiftAmount("");
                pdfBeans.add(pdfBean);
            }
        }
        return pdfBeans;
    }
}
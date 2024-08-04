package org.jern.app;

import org.jern.bean.PDFBean;
import org.jern.constant.Constant;
import org.jern.util.GetAllPath;
import org.jern.util.GetPDFText;
import org.jern.util.WriteExecl;

import java.io.IOException;
import java.util.ArrayList;

public class PDFToExeclAPP {
    public static void main(String[] args) throws IOException {
        // 1.拿到所有pdf路径
        ArrayList<String> allPath = GetAllPath.getAllPath(Constant.PDF_PATH, ".pdf");
        // 2.创建一个ArrayList作为写出execl集合
        ArrayList<PDFBean> execlText = new ArrayList<>();
        // 3.根据每个pdf路径拿到bean对象
        for (String path : allPath) {
            ArrayList<PDFBean> pdfText = GetPDFText.getPDFText(path, Constant.PDF_REGEX);
            for (PDFBean pdfBean : pdfText) {
                // 将每个pdf的bean对象添加到execl集合中
                execlText.add(pdfBean);
            }
        }
        // 4.写出到execl
        WriteExecl.writeExecl(Constant.EXCEL_PATH, Constant.EXCEL_SHEET_NAME, execlText, PDFBean.class);
    }
}

package org.jern.util;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;

public class WriteExecl {
    public static <T> void writeExecl(String path, String sheetName, ArrayList<T> list, Class<T> clazz) {
        EasyExcel.write(path, clazz).sheet(sheetName).doWrite(list);
    }
}

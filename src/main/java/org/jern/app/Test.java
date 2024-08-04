package org.jern.app;

import org.jern.util.GetAllPath;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> allPath = GetAllPath.getAllPath("G:\\resoure\\", ".xlsx");
        System.out.println(allPath);
    }
}

package org.jern.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GetAllPath {
    // 获取所有文件路径
    // ParentPath ：父目录
    // regex ：后缀
    public static ArrayList<String> getAllPath(String ParentPath, String regex) {
        ArrayList<String> list = new ArrayList<>();
        // 获取该文件夹下所有以后缀为结尾的文件路径
        Path folderPath = Paths.get(ParentPath);
        try {
            Files.walk(folderPath)
                    .filter(path -> path.toString().endsWith(regex))
                    .forEach(path -> list.add(path.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

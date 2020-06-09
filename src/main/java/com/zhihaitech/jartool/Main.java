package com.zhihaitech.jartool;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author dhjzzl
 */
public class Main{
    public static void main(String[]args){
        List<String> lines = null;
        try {
            lines = FileUtil.readFile(Main.class.getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (lines != null) {
            lines.forEach(x->{
                String[] split = x.split(",");
                String jarFileFullPath = split[0];
                String targetFullPath = split[1];
                String sourceFullPath = split[2];

                try {
                    JarUtil.readJARList(jarFileFullPath);

                    //FileInputStream fs = new FileInputStream(sourceFullPath);
                    //byte[] readStream = FileUtil.readStream(fs);

                    //JarUtil.writeJarFile(jarFileFullPath,targetFullPath,readStream);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
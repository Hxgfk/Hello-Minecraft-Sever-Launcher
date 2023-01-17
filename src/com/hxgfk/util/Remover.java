package com.hxgfk.util;

import java.io.File;

public class Remover {
    public static void removeDirectory(String path)
    {
        File file = new File(path);
        if(file.isFile())
        {
            file.delete();
        }else {
            File[] files = file.listFiles();
            if(files == null)
            {
                file.delete();
            }else
            {
                for (File value : files) {
                    removeDirectory(value.getAbsolutePath());
                }
                file.delete();
            }
        }
    }

    public static void removeFile(String path){
        new File(path).delete();
    }
}

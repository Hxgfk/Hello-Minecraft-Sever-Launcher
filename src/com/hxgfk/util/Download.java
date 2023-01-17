package com.hxgfk.util;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Download {
    public final String path;
    public final String url;

    public Download(String SavePath, String Url) {
        this.path = SavePath;
        this.url = Url;
    }

    public boolean run() throws IOException{
        int byteread;

        URL url = new URL(this.url);
        URLConnection conn = url.openConnection();
        conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
        InputStream inStream = conn.getInputStream();
        try(FileOutputStream fs = new FileOutputStream(this.path)){
            byte[] buffer = new byte[2048];
            while ((byteread = inStream.read(buffer)) != -1) {
                fs.write(buffer, 0, byteread);
            }
        }

        File file = new File(this.path);
        return file.exists();
    }
}

package com.xtli.controller.javaweb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DownLoadPicTest {
	public static void main(String[] args) throws Exception {
		String path = "http://img.blog.csdn.net/20170711230908704?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center";
		downLoadPic(path);
//		int a = 1;
//		System.out.println(Integer.toBinaryString(a));
//		System.out.println(a<<2);
//		System.out.println(Integer.toBinaryString(a<<2));
		
	}
	private static void downLoadPic(String path) throws IOException {
		URL url = null;  
        int imageNumber = 0;  
          
        try {  
            url = new URL(path);  
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            //FilterInputStream dataInputStream = new FilterInputStream();
            String imageName = imageNumber + ".jpg";  
                FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\"+imageName));  
  
                byte[] buffer = new byte[1024];  
                int length;  
  
                while ((length = dataInputStream.read(buffer)) > 0) {  
                    fileOutputStream.write(buffer, 0, length);  
                }  
  
                dataInputStream.close();  
                fileOutputStream.close();  
            } catch (MalformedURLException e) {  
                e.printStackTrace();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
	}
}

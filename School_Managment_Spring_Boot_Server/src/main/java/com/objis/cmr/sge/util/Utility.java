package com.objis.cmr.sge.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Utility {
	
	 public static byte[] readBytesFromFile(File file) {

	        FileInputStream fileInputStream = null;
	        byte[] bytesArray = null;

	        try {

	             //= new File(filePath);
	            bytesArray = new byte[(int) file.length()];

	            //read file into bytes[]
	            fileInputStream = new FileInputStream(file);
	            fileInputStream.read(bytesArray);

	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (fileInputStream != null) {
	                try {
	                    fileInputStream.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }

	        }

	        return bytesArray;

	    }

}

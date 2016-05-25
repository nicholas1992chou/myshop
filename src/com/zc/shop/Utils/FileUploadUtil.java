package com.zc.shop.Utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

public class FileUploadUtil {
	private String filePath = null;
	
	private String createNewFileName(String fileName){
		//通过文件完整路径名，获取后缀，随机产生新文件完整路径名。
		String ext = fileName.substring(fileName.lastIndexOf("."));
		return UUID.randomUUID().toString() +  ext;
	}
	public String copy(File srcFile, String fileName){
		String newFileName = createNewFileName(fileName);
		File destFile = new File(filePath , newFileName);
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally {
			srcFile.delete();
		}
		return newFileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}

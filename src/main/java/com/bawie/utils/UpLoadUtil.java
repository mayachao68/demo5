package com.bawie.utils;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UpLoadUtil {
	
	public static String getPaths(@RequestParam("file")MultipartFile file) throws IllegalStateException, IOException {
		//长传文件
		//获取文件名
		String filename = file.getOriginalFilename();
		//文件上传后的路径
		File path = new File(ResourceUtils.getURL("classpath:").getPath());
		String paths = "static/imgFile/"+filename;
		File upLoad = new File(path.getAbsolutePath(),paths);
		if(!upLoad.getParentFile().exists()) {
			upLoad.getParentFile().mkdirs();
		}
		file.transferTo(upLoad);
		return paths;
	}
}

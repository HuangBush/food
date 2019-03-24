package com.hyf.food.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	/**
	 * 处理单个文件 MultipartFile[] myfile
	 * @param myfile
	 * @param model
	 * @param request
	 * @return 返回文件上传后的文件相对路径
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String upload(MultipartFile myfile,
			HttpServletRequest request) throws IllegalStateException, IOException{
		//获取原始文件名
		String fileName = myfile.getOriginalFilename();
		//对文件名进行截取从/后面一位开始截取子字符串
		String name2 = fileName.substring(fileName.lastIndexOf("/")+1);
		//对名字进行更改防止重名
		Long time = System.currentTimeMillis();
		String newName = time+name2;
		//定义需要存储的路径 存储路径每日一个
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String day = format.format(new Date());
		//文件存储的相对路径
		String path = "/upload/" + day;
		//获取需要存储的路径的绝对路径
		String realPath = request.getServletContext().getRealPath(path);
		//判断文件夹是否存在，如果不存在则创建目录
		File dayFile = new File(realPath);
		if(!dayFile.exists()){
			dayFile.mkdirs();
		}
		//上传文件到服务器
		String newFileName = realPath +"/"+ newName;
		File newFile = new File(newFileName);
		//将文件传输到服务器
		myfile.transferTo(newFile);
		//返回文件上传后的文件相对路径
		return path+"/"+ newName;
	}
	
	/**
	 * 处理多个文件 MultipartFile[] myfile
	 * @param myfile
	 * @param model
	 * @param request
	 * @return fileNameList  返回上传的文件的列表
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static List<String> upload2(MultipartFile[] myfiles,
			HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println("处理多个文件 MultipartFile[] myfile");
		List<String> fileNameList = new ArrayList<String>(0);
		for(MultipartFile myfile : myfiles){
			System.out.println("------------------+++++++++++++++++"+myfile);
			//获取原始文件名
			String fileName = myfile.getOriginalFilename();
			System.out.println("获取原始文件名================="+fileName);
			//对文件名进行截取从/后面一位开始截取子字符串
			String name2 = fileName.substring(fileName.lastIndexOf("/")+1);
			//对名字进行更改防止重名
			Long time = System.currentTimeMillis();
			String newName = time+name2;
			//定义需要存储的路径 存储路径每日一个
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String day = format.format(new Date());
			//文件存储的相对路径
			String path = "/upload/" + day;
			//获取需要存储的路径的绝对路径
			String realPath = request.getServletContext().getRealPath(path);
			//判断文件夹是否存在，如果不存在则创建目录
			File dayFile = new File(realPath);
			if(!dayFile.exists()){
				dayFile.mkdirs();
			}
			//上传文件到服务器
			String newFileName = realPath +"/"+ newName;
			File newFile = new File(newFileName);
			//将文件传输到服务器
			myfile.transferTo(newFile);
			fileNameList.add(path+"/"+ newName);
		}
		return fileNameList;
	}
}

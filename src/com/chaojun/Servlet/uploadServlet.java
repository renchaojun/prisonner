package com.chaojun.Servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.chaojun.Utils.readExcel;

/**
 * Servlet implementation class Id
 */
@WebServlet("/upload")
@MultipartConfig
public class uploadServlet extends HttpServlet {
	private Logger logger=Logger.getLogger(mainServlet.class);
	private static final String UPLOAD_DIRECTORY="upload";
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//1.设置响应编码格式
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		//2.获取提交的犯人的类型信息
		String type=req.getParameter("text");
//		System.out.println("类型："+type);
			// 这个路径相对当前应用的目录
	    String uploadPath=req.getServletContext().getRealPath("")+File.separator+UPLOAD_DIRECTORY;
//	    System.out.println(uploadPath);
	    //目录不存在则创建
	    File uploaDir=new File(uploadPath);
	    if(!uploaDir.exists()) {
	    	uploaDir.mkdir();
	    	logger.debug("新建上传文件夹成功！");
	    }
	    Part filePart=req.getPart("file");
	    if(filePart!=null) {
	    	String fileName=getFilename(filePart);
	    	boolean flag=false;
	    	if(fileName.endsWith(".xlsx")) flag=true;
	    	if(flag) {
	    		filePart.write(uploadPath+"/"+fileName);
	    		System.out.println(fileName+"上传文件成功！  类型为："+type);
	    		resp.getWriter().write(fileName+"上传文件成功！");
	    		//3.读取文件到数据库
//	 	    	readExcel.processExcel(uploadPath+"/"+fileName,type);
	    	}else {
	    		resp.getWriter().write("文件导入出错,只支持.xlsx格式");
	    	}
	    }else {
	    	resp.getWriter().write("上传失败！");
	    	logger.debug("上传失败！");
	    }
//	    String fileName = Paths.get(filePart.getName()).getFileName().toString(); // MSIE fix.
//	    InputStream fileContent = filePart.getInputStream();
	}
	private String getFilename(Part part){
		String contentDispositoinHeader=part.getHeader("content-disposition");
		String [] elements=contentDispositoinHeader.split(";");
		for(String element:elements){
			if(element.trim().startsWith("filename")){
				return element.substring(
						element.indexOf('=')+1).trim().replace("\"", "");
			}
		}
	return null;
	}
}

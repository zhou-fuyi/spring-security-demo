package com.imooc.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.imooc.dto.FileInfo;

/**
  *  文件上传下载
 * @author ZhouJian
 *
 */
@RestController
@RequestMapping("/file")
public class FileController {

	private String folder = "E:\\workspace\\sts-eclipse\\imooc-security\\imooc-security-demo\\src\\main\\java\\com\\imooc\\web\\controller";
	
	@PostMapping
	public FileInfo upload(MultipartFile file) throws IllegalStateException, IOException {
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		File localFile = new File(folder, new Date().getTime() + ".txt");
		file.transferTo(localFile);
		return new FileInfo(localFile.getAbsolutePath());
	}
	
	@GetMapping("/{id}")
	public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
		
		try (
				InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
				OutputStream outputStream = response.getOutputStream();
				){
			response.setContentType("application/x-download");
			response.setHeader("Content-Disposition", "attachment;filename=test.txt");//设置下载时文件名
			IOUtils.copy(inputStream, outputStream);
			outputStream.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}

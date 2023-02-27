package com.teibok.models;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Servlet implementation class FileUpload
 */
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("fileName");
		String fileName = part.getSubmittedFileName();
		String fileType = request.getParameter("fileType");
		InputStream fileInputStream = null;
		FileOutputStream fileOutput = null;
		try{
			fileInputStream = part.getInputStream();
			File file = null;
			if(fileType.equals("uncompressed")) {
				file = new File("D://Projects//ServerMemory//Uncompressed//"+fileName);
			}else if(fileType.equals("compressed")) {
				file = new File("D://Projects//ServerMemory//Compressed//"+fileName);
			}
			fileOutput = new FileOutputStream(file);
			byte[] b = new byte[fileInputStream.available()];
			fileInputStream.read(b);
			fileOutput.write(b);
			if(fileType.equals("uncompressed")) {
				CommonData.setUncompressedFilePath("D://Projects//ServerMemory//Uncompressed//"+fileName);
				CommonData.setDownloadCompressedFilePath("D://Projects//ServerMemory//Compressed//"+fileName);
				CommonData.setDownloadCompressedFileName(fileName);
			}else if(fileType.equals("compressed")) {
				CommonData.setCompressedFilePath("D://Projects//ServerMemory//Compressed//"+fileName);
				CommonData.setDownloadDecompressedFilePath("D://Projects//ServerMemory//Uncompressed//"+fileName);
				CommonData.setDownloadDecompressedFileName(fileName);
			}
		}
		catch(FileNotFoundException err) {
			System.out.println(err);
		}
		finally {
			if(fileInputStream != null) {
				fileInputStream.close();
			}
			if(fileOutput != null) {
				fileOutput.close();
			}
		}
	}
}

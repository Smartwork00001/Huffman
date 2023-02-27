package com.teibok.models;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DownloadDecompressedFile
 */
public class DownloadDecompressedFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter(); 
		String filename = CommonData.getDownloadDecompressedFileName();   
		String filepath = CommonData.getDownloadDecompressedFilePath();   
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
		  
		FileInputStream fileInputStream = new FileInputStream(filepath);  
		System.out.println("GET DownloadDecompressedFile filename= "+filename+" filepath= "+filepath+" size="+fileInputStream.available());
		int i;
		while((i=fileInputStream.read()) != -1) {
			out.write(i);
		}
		fileInputStream.close(); 
		out.flush();
		out.close();
	}

}

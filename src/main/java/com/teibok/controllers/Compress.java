package com.teibok.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.teibok.models.CommonData;
import com.teibok.models.HuffmanTreeNode;
import com.teibok.models.Reader;
import com.teibok.models.Writer;

/**
 * Servlet implementation class Compress
 */
public class Compress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Compress GET "+CommonData.getUncompressedFilePath());
		Reader reader = new Reader();
		byte[] b = reader.readFile(CommonData.getUncompressedFilePath());
		HashMap<Byte, Integer> freqMap = reader.getFrequencyMap(b);
		HuffmanTreeNode huffmanTreeRoot = reader.createHuffmanTree(freqMap); 
		HashMap<Byte, String> byteToBitMap = reader.getByteToBitMap(huffmanTreeRoot);
		Writer writer = new Writer();
        writer.writeToBinaryFile(byteToBitMap, freqMap, b);
	}

}

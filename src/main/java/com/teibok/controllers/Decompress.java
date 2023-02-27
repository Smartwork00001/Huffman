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
 * Servlet implementation class Decompress
 */
public class Decompress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reader reader = new Reader();
	    byte[] inputByteArr = reader.readFile(CommonData.getCompressedFilePath());
	    
	    Writer writer = new Writer();
	    
	    StringBuffer sb = new StringBuffer();
	    int startSb = inputByteArr[0];
	    int last = inputByteArr.length;
	    startSb = startSb*3+1;
	    for(int i=startSb ; i<last-2 ; ++i){
	        sb.append(writer.convertByteToString(inputByteArr[i]));
	    }
	    String temp = writer.convertByteToString(inputByteArr[last-2]);
	    sb.append(temp.substring(0,8-((int) inputByteArr[last-1])));
	    HashMap<Byte,Integer> freqMap = new HashMap<>();
	    for(int i=1; i<startSb; i+=3){
	        int temp2 = (inputByteArr[i+1] & 0xff);
	        int temp3 = (inputByteArr[i+2] & 0xff);
	        int freq =  (temp2<<8) | (temp3); 
	        freqMap.put(inputByteArr[i],freq);
	    }
	    HuffmanTreeNode huffmanTreeRoot = reader.createHuffmanTree(freqMap);
	    HuffmanTreeNode node = huffmanTreeRoot;
	    ArrayList<Byte> al = new ArrayList<>();
//	    while(sb.length()>0){
//	        if(sb.charAt(0)=='1'){
//	            node = node.right;
//	            if(node.left == null && node.right == null){
//	                al.add(node.byt);
//	                node = huffmanTreeRoot;
//	            }
//	        }else{
//	            node = node.left;
//	            if(node.left == null && node.right == null){
//	                al.add(node.byt);
//	                node = huffmanTreeRoot;
//	            }
//	        }
//	        sb.deleteCharAt(0);
//	    }
	    while(sb.length()>0){
	        if(sb.charAt(0)=='1'){
	            node = node.getRight();
	            if(node.getLeft() == null && node.getRight() == null){
	                al.add(node.getByt());
	                node = huffmanTreeRoot;
	            }
	        }else{
	            node = node.getLeft();
	            if(node.getLeft() == null && node.getRight() == null){
	                al.add(node.getByt());
	                node = huffmanTreeRoot;
	            }
	        }
	        sb.deleteCharAt(0);
	    }
	    byte[] outputByteArr = new byte[al.size()];
	    for(int i=0;i<al.size();++i){
	        outputByteArr[i] = al.get(i);
	    }
	    writer.writeFile(CommonData.getDownloadDecompressedFilePath(), outputByteArr);
	}

}

//public void writeToTextFile(){
//    Reader reader = new Reader();
//    byte[] inputByteArr = reader.readFile("D:\\Projects\\ServerMemory\\Output.txt");
//    StringBuffer sb = new StringBuffer();
//    int startSb = inputByteArr[0];
//    int last = inputByteArr.length;
//    startSb = startSb*3+1;
//    for(int i=startSb ; i<last-2 ; ++i){
//        sb.append(convertByteToString(inputByteArr[i]));
//    }
//    String temp = convertByteToString(inputByteArr[last-2]);
//    sb.append(temp.substring(0,8-((int) inputByteArr[last-1])));
//    HashMap<Byte,Integer> freqMap = new HashMap<>();
//    for(int i=1; i<startSb; i+=3){
//        int temp2 = (inputByteArr[i+1] & 0xff);
//        int temp3 = (inputByteArr[i+2] & 0xff);
//        int freq =  (temp2<<8) | (temp3); 
//        freqMap.put(inputByteArr[i],freq);
//    }
//    HuffmanTreeNode huffmanTreeRoot = reader.createHuffmanTree(freqMap);
//    HuffmanTreeNode node = huffmanTreeRoot;
//    ArrayList<Byte> al = new ArrayList<>();
//    while(sb.length()>0){
//        if(sb.charAt(0)=='1'){
//            node = node.right;
//            if(node.left == null && node.right == null){
//                al.add(node.byt);
//                node = huffmanTreeRoot;
//            }
//        }else{
//            node = node.left;
//            if(node.left == null && node.right == null){
//                al.add(node.byt);
//                node = huffmanTreeRoot;
//            }
//        }
//        sb.deleteCharAt(0);
//    }
//    byte[] outputByteArr = new byte[al.size()];
//    for(int i=0;i<al.size();++i){
//        outputByteArr[i] = al.get(i);
//    }
//    writeFile("D:\\Projects\\ServerMemory\\Output2.txt", outputByteArr);
//        
//}

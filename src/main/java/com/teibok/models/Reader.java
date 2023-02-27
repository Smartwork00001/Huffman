package com.teibok.models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Reader {
	public byte[] readFile(String filePath){
		FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(filePath);
            byte[] b = new byte[inputFile.available()];
            inputFile.read(b);
            return b;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
        	if(inputFile != null) {
        		try {
					inputFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
		}
        return new byte[0];
    }
	
	public HashMap<Byte, Integer> getFrequencyMap(byte[] b){
        HashMap<Byte, Integer> freqMap = new HashMap<>();
        for(int i=0;i<b.length;++i){
            freqMap.put(b[i], freqMap.getOrDefault(b[i], 0)+1);
        }
        return freqMap;
    }
	
	public HuffmanTreeNode createHuffmanTree(HashMap<Byte, Integer> freqMap){
        PriorityQueue<HuffmanTreeNode> priorityQueue = new PriorityQueue<>();
        for(byte b: freqMap.keySet()){
            priorityQueue.add(new HuffmanTreeNode(b, freqMap.get(b)));
        }
        while(priorityQueue.size()>1){
            HuffmanTreeNode a = priorityQueue.remove();
            HuffmanTreeNode b = priorityQueue.remove();
            HuffmanTreeNode parent = new HuffmanTreeNode((byte) 10, a.freq +b.freq);
            parent.left = a;
            parent.right = b;
            priorityQueue.add(parent);
        }
        return priorityQueue.remove();
    }
	
	public HashMap<Byte, String> getByteToBitMap(HuffmanTreeNode huffmanTreeRoot){
        HashMap<Byte, String> byteToBitMap = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        traverseTree(byteToBitMap, sb, huffmanTreeRoot);
        return byteToBitMap;
    }
	
	public void traverseTree(HashMap<Byte, String> byteToBitMap, StringBuffer sb, HuffmanTreeNode huffmanTreeNode){
        if(huffmanTreeNode == null){
            return;
        }
        sb.append('0');
        traverseTree(byteToBitMap, sb, huffmanTreeNode.left);
        sb.deleteCharAt(sb.length()-1);
        if(huffmanTreeNode.left == null && huffmanTreeNode.right == null){
            byteToBitMap.put(huffmanTreeNode.byt, sb.toString());
        }
        sb.append('1');
        traverseTree(byteToBitMap, sb, huffmanTreeNode.right);
        sb.deleteCharAt(sb.length()-1);

    }
}

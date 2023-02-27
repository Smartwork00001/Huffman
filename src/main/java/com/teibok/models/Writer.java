package com.teibok.models;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Writer {

    public byte convertStringToByte(String s){
        byte res = (byte) Integer.parseInt(s, 2);
        return res;
    }

    public String convertByteToString(byte b){
        return String.format("%8s", Integer.toBinaryString(b & 0xff)).replace(' ', '0');
    }

    public void writeFile(String filePath, byte[] outputByteArr){
        try {
            FileOutputStream outputFile = new FileOutputStream(filePath);
            outputFile.write(outputByteArr);
            outputFile.flush();
            outputFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToBinaryFile(HashMap<Byte, String> byteToBitMap, HashMap<Byte, Integer> freqMap, byte[] inputByteArr){        
            StringBuffer sb = new StringBuffer();
            int numUniqueBytes = byteToBitMap.size();
            ArrayList<Byte> al = new ArrayList<>();
            al.add((byte) numUniqueBytes);
            for(byte x: byteToBitMap.keySet()){
                al.add(x);
                int freq = freqMap.get(x);
                al.add((byte) (freq>>8));
                al.add((byte) freq);
            }
            for(int i=0;i<inputByteArr.length;++i){
                sb.append(byteToBitMap.get(inputByteArr[i]));
            }
            for(int i=sb.length()/8; i>0; --i){
                al.add(convertStringToByte(sb.substring(0,8)));
                sb.delete(0,8);
            }
            byte padding = 0;
            while(sb.length() != 8){
                sb.append('0');
                ++padding;
            }
            al.add(convertStringToByte(sb.toString()));
            al.add(padding);
            
            byte[] outputByteArr = new byte[al.size()];
            for(int i=0;i<al.size();++i){
                outputByteArr[i] = al.get(i);
            }
            writeFile(CommonData.getDownloadCompressedFilePath(), outputByteArr); 
        
    }
}

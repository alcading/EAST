package com.huateng.report.imports.common;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadWriteFile {
    //指定文件路径和名称
    private String path;
    private  File filename;
    private  String readStr ="";

    public ReadWriteFile(String path,String name){
    	this.path=path;
    	filename = new File(path+name);
    }
    
    public void deleteFile(){
    	if(filename.exists()){
    		filename.delete();
    	}
    }

    /** *//**
     * 创建文本文件.
     * @throws IOException 
     * 
     */
    public  void creatTxtFile() throws IOException{
    	newFolder(path);
        if (!filename.exists()) {
            filename.createNewFile();
        }
    }
    
    public void newFolder(String folderPath) {   
        try {   
          String filePath = folderPath;   
           filePath = filePath.toString();   
           java.io.File myFilePath = new java.io.File(filePath);   
           if (!myFilePath.exists()) {   
               myFilePath.mkdirs();   
            }   
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
   }
    
    /** *//**
     * 读取文本文件.
     * 
     */
    public  String readTxtFile(){
    	readStr="";
        String read;
        FileReader fileread = null;
        BufferedReader bufread=null;
        try {
            fileread = new FileReader(filename);
            bufread = new BufferedReader(fileread);
             while ((read = bufread.readLine()) != null) {
                   readStr = readStr + read+ "\r\n";
             }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(bufread!=null)
					bufread.close();
			    if(fileread!=null)
			    	fileread.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        return readStr;
    }
    
  
    
    /** *//**
     * 写文件.
     * 
     */
    public  void writeTxtFile(String newStr) throws IOException{
    	readTxtFile();
        //先读取原有文件内容，然后进行写入操作
        String filein =readStr +newStr;
        RandomAccessFile mm = null;
        try {
            mm = new RandomAccessFile(filename, "rw");
            mm.write(filein.getBytes());
        } catch (IOException e1) {
            // TODO 自动生成 catch 块
            e1.printStackTrace();
        } finally {
            if (mm != null) {
                try {
                    mm.close();
                } catch (IOException e2) {
                    // TODO 自动生成 catch 块
                    e2.printStackTrace();
                }
            }
        }
    }
    
    public  void replaceTxtFile(String newStr) throws IOException{
        //先读取原有文件内容，然后进行写入操作
    	deleteFile();
    	creatTxtFile();
        String filein =newStr;
        RandomAccessFile mm = null;
        try {
            mm = new RandomAccessFile(filename, "rw");
            mm.write(filein.getBytes());
        } catch (IOException e1) {
            // TODO 自动生成 catch 块
            e1.printStackTrace();
        } finally {
            if (mm != null) {
                try {
                    mm.close();
                } catch (IOException e2) {
                    // TODO 自动生成 catch 块
                    e2.printStackTrace();
                }
            }
        }
    }
}

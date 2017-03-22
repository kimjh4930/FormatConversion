package com.convert.handlingfiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadingFile {

	public String readOriginalResult(String filename){
		
		File file = new File(filename);
		
		String line="";
		String temp;
		
		try{
			Scanner scanner = new Scanner(file,"UTF-8");
			
			while((temp = scanner.nextLine()) != null){
				line += (temp+"\n");
			}
			
		}catch(Exception e){
			
		}
		
		return line;
	}
	
	public List<String> loadFileList(String path){
		
		List<String> fileList = new ArrayList<>();
		
		File dir = new File(path);
		File[] contentList = dir.listFiles();
		
		for(int i=0; i< contentList.length; i++){
			File file = contentList[i];
			
			if(  file.getName().contains(".txt") ){
				fileList.add(file.getName());
			}
		}
		
		return fileList;
	}

}

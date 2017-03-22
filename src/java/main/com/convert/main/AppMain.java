package com.convert.main;

import java.util.ArrayList;
import java.util.List;

import com.convert.dataprocessing.ProcessingData;
import com.convert.domain.AfterDataType;
import com.convert.domain.AfterDataType;
import com.convert.domain.BeforeDataType;
import com.convert.handlingfiles.ReadingFile;
import com.convert.handlingfiles.WritingFile;

public class AppMain {
	
	public static void main(String[] args) {
		
		ReadingFile readingFile = new ReadingFile();
		ProcessingData processingData = new ProcessingData();
		WritingFile writingFile = new WritingFile();
		
		List<String> fileList = new ArrayList<>();
		
		String path = "../result/stream/";
		String rawDataRegex = String.format(".+\n.+\n.+\n=========================");
		
		//fileList에 
		fileList = readingFile.loadFileList(path);
		
		for(int i=0; i<fileList.size(); i++){
			List<AfterDataType> afterDataList = new ArrayList<>();
			List<String> dataList = new ArrayList<>();
			BeforeDataType beforeData = new BeforeDataType();
			
			System.out.println(path + fileList.get(i));
			
			String content = readingFile.readOriginalResult(path + fileList.get(i));
			
			dataList = processingData.getDataListFromRegex(content, rawDataRegex);
			for(int j=0; j<dataList.size(); j++){
				
				beforeData = processingData.extractData(dataList.get(j));
				afterDataList.add(processingData.makeOutputFormat(beforeData));
				
			}
			
			System.out.println(afterDataList);
			writingFile.writeToFile(path, afterDataList, fileList.get(i));
			
			
		}
		
	}

}

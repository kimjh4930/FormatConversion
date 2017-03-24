package com.convert.main;

import java.util.ArrayList;
import java.util.List;

import com.convert.dataprocessing.ProcessingData;
import com.convert.domain.AfterDataType;
import com.convert.domain.BeforeDataType;
import com.convert.handlingfiles.ReadingFile;
import com.convert.handlingfiles.WritingFile;

public class AppMain {
	
	public static void main(String[] args) {
		
		ReadingFile readingFile = new ReadingFile();
		ProcessingData processingData = new ProcessingData();
		WritingFile writingFile = new WritingFile();
		
		List<String> cpuFrequency = new ArrayList<>();
		
		String path = "../result/iozone/";
		String rawDataRegex = String.format(".+\n.+\n.+\n=========================");
		
		//fileList에 
		cpuFrequency = readingFile.loadFileList(path);
		
		System.out.println(cpuFrequency);
		
		for(int i=0; i<cpuFrequency.size(); i++){
		//for(int i=0; i<3; i++){
			List<AfterDataType> afterDataList = new ArrayList<>();
			List<String> dataList = new ArrayList<>();
			BeforeDataType beforeData = new BeforeDataType();
			
			System.out.println(path + cpuFrequency.get(i));
			
			String content = readingFile.readOriginalResult(path + cpuFrequency.get(i) + ".txt");
			
			dataList = processingData.getDataListFromRegex(content, rawDataRegex);
			
			System.out.println(dataList);
			
			for(int j=0; j<dataList.size(); j++){
				
				beforeData = processingData.extractData(dataList.get(j));
				beforeData.setCpuFrequency(Integer.parseInt(cpuFrequency.get(i)));
				
				afterDataList.add(processingData.makeOutputFormat(beforeData));
				
			}
			System.out.println(afterDataList);

			for(int j=0; j < afterDataList.size(); j++){
				writingFile.writeToFile(path, afterDataList.get(j), "cpufreq", cpuFrequency.get(i)+".txt");
				writingFile.writeToFile(path, afterDataList.get(j), "devfreq", afterDataList.get(j).getDevFrequency() + ".txt");
			}
			
			
			
		}
		
	}

}

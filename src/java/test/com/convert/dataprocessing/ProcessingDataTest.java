package com.convert.dataprocessing;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.convert.domain.BeforeDataType;
import com.convert.handlingfiles.ReadingFile;

public class ProcessingDataTest {
	
	@Test
	public void getDataFromRegex_구간결과값을_가져온다(){
		ProcessingData processingData = new ProcessingData();
		List<String> regexResult = new ArrayList<>();
		
		String readData;
		ReadingFile readingFile = new ReadingFile();
		
		readData = readingFile.readOriginalResult("2000000_bt.A.x.txt");
		
		//System.out.println(readData);
		
		String regex = String.format(".+\n.+\n.+\n=========================");
		//".+\n.+\n.+\n========================="
		regexResult = processingData.getDataListFromRegex(readData, regex);
		
		for(int i=0; i<regexResult.size(); i++){
			BeforeDataType beforeData = processingData.extractData(regexResult.get(i));
			System.out.println(processingData.makeOutputFormat(beforeData).toString());
		}
		
		
		
		
	}

}

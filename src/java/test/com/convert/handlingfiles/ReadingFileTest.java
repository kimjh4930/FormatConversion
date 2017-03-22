package com.convert.handlingfiles;

import org.junit.Ignore;
import org.junit.Test;

public class ReadingFileTest {
	
	@Ignore
	@Test
	public void readingOriginalResult_결과리스트를_불러온다(){
		ReadingFile readingFile = new ReadingFile();
		
		String result = readingFile.readOriginalResult("./");
		
		System.out.println(result);
		
	}
	
	@Test
	public void loadFileList_파일리스트를_불러온다(){
		ReadingFile readingFile = new ReadingFile();
		
		System.out.println(readingFile.loadFileList("../"));
	}

}

package com.convert.handlingfiles;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import com.convert.domain.AfterDataType;

public class WritingFile {

	public void writeToFile(String path, List<AfterDataType> dataList, String fileName) {

		try {

			String convertPath = path + "convert" + "/";
			
			System.out.println(convertPath);
			
			File directory = new File(convertPath);

			if (!directory.exists()) {
				directory.mkdirs();
			}

			File file = new File(convertPath + fileName);

			FileWriter fw = new FileWriter(file, true);

			for(int i=0; i<dataList.size(); i++){
				fw.write(dataList.get(i).toString() + "\n");
			}
			fw.flush();

			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package com.convert.handlingfiles;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import com.convert.domain.AfterDataType;

public class WritingFile {

	public void writeToFile(String path, AfterDataType data, String directoryName, String fileName) {

		try {

			String convertPath = path + directoryName + "/";
			
			System.out.println(convertPath);
			
			File directory = new File(convertPath);

			if (!directory.exists()) {
				directory.mkdirs();
			}

			File file = new File(convertPath + fileName);

			FileWriter fw = new FileWriter(file, true);
			
			if("cpufreq".equals(directoryName)){
				//fw.write(data.toStringSortedByDevFreq() + "\n");
				//nexus
				fw.write(data.toStringSortedByDevFreqNexus() + "\n");
			}else if("devfreq".equals(directoryName)){
				
				//fw.write(data.toStringSotredByCpuFreq() + "\n");
				//nexus
				fw.write(data.toStringSotredByCpuFreq() + "\n");
			}
			
			fw.flush();

			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

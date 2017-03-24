package com.convert.dataprocessing;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.convert.domain.AfterDataType;
import com.convert.domain.BeforeDataType;

public class ProcessingData {
	
	public List<String> getDataListFromRegex(String rawData, String regex) {

		List<String> extractedData = new ArrayList<String>();

		Pattern dataPattern = Pattern.compile(regex);
		Matcher dataMatcher = dataPattern.matcher(rawData.trim());

		while (dataMatcher.find()) {
			extractedData.add(dataMatcher.group(0).trim());
		}

		return extractedData;
	}
	
	public String getDataStringFromRegex(String rawData, String regex){
		
		String result = "";
		
		Pattern dataPattern = Pattern.compile(regex);
		Matcher dataMatcher = dataPattern.matcher(rawData.trim());

		while (dataMatcher.find()) {
			result = dataMatcher.group(0).trim();
		}
		
		return result;
	}
	
	public BeforeDataType extractData(String rawData){
		
		BeforeDataType dataType = new BeforeDataType();
		
		String frequencyResult;
		String whResult;
		String minuteResult;
		String secondResult;
		
		String freqRegex = String.format("\\d+mhz");
		String whRegex = String.format("\\d+,\\d+\\.\\d{3},\\d+\\.\\d{3},\\d{1,2}\\.\\d{3},\\d\\.\\d{1,3}");
		String minuteRegex = String.format("\\d{1,3}m");
		String secondRegex = String.format("m\\d{1,2}\\.\\d{0,3}");
		
		frequencyResult = this.getDataStringFromRegex(rawData, freqRegex).toString().replaceAll("mhz", "");
		whResult = this.splitRawData(",", this.getDataStringFromRegex(rawData, whRegex).toString());
		minuteResult = this.getDataStringFromRegex(rawData, minuteRegex).toString().replaceAll("m", "");
		secondResult = this.getDataStringFromRegex(rawData, secondRegex).toString().replaceAll("m", "");
		
		dataType.setDevFrequency(Integer.parseInt(frequencyResult));
		dataType.setWattHour(Double.parseDouble(whResult));
		dataType.setExeTime(Double.parseDouble(minuteResult)*60 + Double.parseDouble(secondResult));
		
		return dataType;
	}
	
	public String splitRawData(String splitWord, String rawData){
		
		String[] splitResult = rawData.split(splitWord);
		
		return splitResult[4];
	}
	
	public AfterDataType makeOutputFormat(BeforeDataType beforeData){
		
		AfterDataType afterData = new AfterDataType();
		
		afterData.setCpuFrequency(beforeData.getCpuFrequency());
		afterData.setDevFrequency(beforeData.getDevFrequency());
		afterData.setExecTime(beforeData.getExeTime());
		afterData.setWattHour(beforeData.getWattHour());
		afterData.setJouleSecond(beforeData.getWattHour() * 3600 * beforeData.getExeTime());
		afterData.setWatt(beforeData.getWattHour() * 3600 / beforeData.getExeTime());
		
		return afterData;
	}

}

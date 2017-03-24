package com.convert.domain;

import lombok.Data;

@Data
public class AfterDataType {
	
	private int devFrequency;
	private int cpuFrequency;
	private Double execTime;
	private Double wattHour;
	private Double jouleSecond;
	private Double watt;
	
	
	public String toStringSortedByDevFreq(){
		
		return	this.getCpuFrequency() + "," +
				this.getDevFrequency() + "," +
				this.getExecTime() + "," +
				this.getWattHour() + "," +
				this.getJouleSecond() + "," +
				this.getWatt();
	}
	
	public String toStringSotredByCpuFreq(){
		
		return 	this.getDevFrequency() + "," +
				this.getCpuFrequency() + "," +
				this.getExecTime() + "," +
				this.getWattHour() + "," +
				this.getJouleSecond() + "," +
				this.getWatt();
	}

}

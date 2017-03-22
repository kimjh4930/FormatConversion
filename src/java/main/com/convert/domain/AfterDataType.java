package com.convert.domain;

import lombok.Data;

@Data
public class AfterDataType {
	
	private int frequency;
	private Double execTime;
	private Double wattHour;
	private Double jouleSecond;
	private Double watt;
	
	@Override
	public String toString(){
		
		return 	this.getFrequency() + "," +
				this.getExecTime() + "," +
				this.getWattHour() + "," +
				this.getJouleSecond() + "," +
				this.getWatt();
	}

}

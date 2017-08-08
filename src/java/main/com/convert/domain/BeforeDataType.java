package com.convert.domain;

public class BeforeDataType {

	private int cpuFrequency;
	private int devFrequency;
	private double wattHour;
	private double exeTime;
	private long cycle;
	private long instruction;

	public long getCycle() {
		return cycle;
	}

	public void setCycle(long cycle) {
		this.cycle = cycle;
	}

	public long getInstruction() {
		return instruction;
	}

	public void setInstruction(long instruction) {
		this.instruction = instruction;
	}

	public int getCpuFrequency() {
		return cpuFrequency;
	}

	public void setCpuFrequency(int cpuFrequency) {
		this.cpuFrequency = cpuFrequency;
	}

	public int getDevFrequency() {
		return devFrequency;
	}

	public void setDevFrequency(int devFrequency) {
		this.devFrequency = devFrequency;
	}

	public double getWattHour() {
		return wattHour;
	}

	public void setWattHour(double wattHour) {
		this.wattHour = wattHour;
	}

	public double getExeTime() {
		return exeTime;
	}

	public void setExeTime(double exeTime) {
		this.exeTime = exeTime;
	}

}

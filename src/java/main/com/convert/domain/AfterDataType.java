package com.convert.domain;

public class AfterDataType {

	private int devFrequency;
	private int cpuFrequency;
	private Double execTime;
	private Double wattHour;
	private Double jouleSecond;
	private Double watt;
	private long cycle;
	private long instruction;
	private double cyclesPerInstruction;

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

	public double getCyclesPerInstruction() {
		return cyclesPerInstruction;
	}

	public void setCyclesPerInstruction(double cyclesPerInstruction) {
		this.cyclesPerInstruction = cyclesPerInstruction;
	}

	public int getDevFrequency() {
		return devFrequency;
	}

	public void setDevFrequency(int devFrequency) {
		this.devFrequency = devFrequency;
	}

	public int getCpuFrequency() {
		return cpuFrequency;
	}

	public void setCpuFrequency(int cpuFrequency) {
		this.cpuFrequency = cpuFrequency;
	}

	public Double getExecTime() {
		return execTime;
	}

	public void setExecTime(Double execTime) {
		this.execTime = execTime;
	}

	public Double getWattHour() {
		return wattHour;
	}

	public void setWattHour(Double wattHour) {
		this.wattHour = wattHour;
	}

	public Double getJouleSecond() {
		return jouleSecond;
	}

	public void setJouleSecond(Double jouleSecond) {
		this.jouleSecond = jouleSecond;
	}

	public Double getWatt() {
		return watt;
	}

	public void setWatt(Double watt) {
		this.watt = watt;
	}

	public String toStringSortedByDevFreq() {

		return this.getCpuFrequency() + "," + this.getDevFrequency() + "," + this.getExecTime() + ","
				+ this.getWattHour() + "," + this.getJouleSecond() + "," + this.getWatt();
	}

	public String toStringSotredByCpuFreq() {

		return this.getDevFrequency() + "," + this.getCpuFrequency() + "," + this.getExecTime() + ","
				+ this.getWattHour() + "," + this.getJouleSecond() + "," + this.getWatt();
	}

	public String toStringSortedByDevFreqNexus() {

		return this.getCpuFrequency() + "," + this.getDevFrequency() + "," + this.getExecTime();
	}

	public String toStringSotredByCpuFreqNexus() {

		return this.getDevFrequency() + "," + this.getCpuFrequency() + "," + this.getExecTime();
	}

	public String toStringSortedByDevFreqPerfNexus() {

		return this.getCpuFrequency() + "," + this.getDevFrequency() + "," + this.getCycle() + ","
				+ this.getInstruction() + "," + this.getCyclesPerInstruction();
	}

	public String toStringSotredByCpuFreqPerfNexus() {

		return this.getDevFrequency() + "," + this.getCpuFrequency() + "," + this.getCycle() + ","
				+ this.getInstruction() + "," + this.getCyclesPerInstruction();
	}

}

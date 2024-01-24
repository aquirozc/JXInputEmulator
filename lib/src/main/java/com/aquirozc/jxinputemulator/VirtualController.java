package com.aquirozc.jxinputemulator;

import com.sun.jna.Pointer;

public class VirtualController{
	
	private VirtualBus service;
	private Pointer busp;
	private Pointer devicep;
	private ViGEmClient client;
	private XUSBReport report;
	
	public VirtualController(ViGEmClient client) {
		
		this.client = client;
		this.service = new VirtualBus(client);
		
		service.connect();
		this.busp = service.getBus();
		
		this.devicep = client.vigem_target_x360_alloc();
		
		client.vigem_target_add(busp,devicep);
		
		report = new XUSBReport();
		update();
	}
	
	public void resetReport() {
		report.wButtons = 0;
		report.bLeftTrigger = 0;
		report.bRightTrigger = 0;
		report.sThumbLX = 0;
		report.sThumbLY = 0;
		report.sThumbRX = 0;
		report.sThumbRY = 0;
	}
	
	public void pressButton(int button) {
		report.wButtons = report.wButtons | button ;
	}
	
	public void releaseButton(int button) {
		report.wButtons = report.wButtons & ~button;
	}
	
	public void setLeftTrigger(int value) {
		report.bLeftTrigger = value;
	}
	
	public void setRightTrigger(int value) {
		report.bRightTrigger = value;
	}
	
	public void setLeftTrigger(float value) {
		report.bLeftTrigger = value;
	}
	
	public void setRightTrigger(float value) {
		report.bRightTrigger = value;
	}
	
	public void setLeftJoystick(int x, int y) {
		report.sThumbLX = x;
		report.sThumbLY = y;
	}
	
	public void setLRightJoystick(int x, int y) {
		report.sThumbRX = x;
		report.sThumbRY = y;
	}
	
	public void update() {
		client.vigem_target_x360_update(busp, devicep,report);
	}
	
	public void remove() {
		client.vigem_target_remove(busp, devicep);
		client.vigem_target_free(devicep);
	}
	
	public void setVID(short VID) {
		client.vigem_target_set_vid(devicep, VID);
	}
	
	public short getVID() {
		return client.vigem_target_get_vid(devicep);
	}
	
	public void setPID(short PID) {
		client.vigem_target_set_pid(devicep, PID);
	}
	
	public short getPID() {
		return client.vigem_target_get_pid(devicep);
	}
	
	public long getIndex() {
		return client.vigem_target_get_index(devicep);
	}

}

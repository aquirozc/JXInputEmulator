package com.aquirozc.jxinputemulator;

import com.sun.jna.Pointer;

public class VirtualXUSB extends VirtualController {
	
	private XUSBReport report = new XUSBReport();

	public VirtualXUSB(ViGEmClient client) {
		super(client);
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
		report.bLeftTrigger = Math.round(255* value);
	}
	
	public void setRightTrigger(float value) {
		report.bRightTrigger = Math.round(255* value);
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
		client.vigem_target_x360_update(bus,device,report);
	}
	

	@Override
	public Pointer allocateTarget() {
		return client.vigem_target_x360_alloc();
	}
	

}

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
	
	public void pressButton(XUSBButton button) {
		report.wButtons = report.wButtons | button.flag ;
	}
	
	public void releaseButton(XUSBButton button) {
		report.wButtons = report.wButtons & ~button.flag;
	}
	
	public void setLeftTrigger(int value) {
		
		if(value < 0 || value > 255) {
			throw new IllegalArgumentException("Input must be an integer between 0 and 255. But was " + value);
		}
		
		report.bLeftTrigger = value;
	}
	
	public void setRightTrigger(int value) {
		
		if(value < 0 || value > 255) {
			throw new IllegalArgumentException("Input must be an integer between 0 and 255. But was " + value);
		}
		
		report.bRightTrigger = value;
	}
	
	public void setLeftTrigger(float value) {
		
		if(value < 0 || value > 1) {
			throw new IllegalArgumentException("Input must be a float between 0 and 1. But was " + value);
		}
		
		report.bLeftTrigger = Math.round(255* value);
	}
	
	public void setRightTrigger(float value) {
		
		if(value < 0 || value > 1) {
			throw new IllegalArgumentException("Input must be a float between 0 and 1. But was " + value);
		}
		
		report.bRightTrigger = Math.round(255* value);
	}
	
	public void setLeftJoystick(short x, short y) {
		report.sThumbLX = x;
		report.sThumbLY = y;
	}
	
	public void setLRightJoystick(short x, short y) {
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

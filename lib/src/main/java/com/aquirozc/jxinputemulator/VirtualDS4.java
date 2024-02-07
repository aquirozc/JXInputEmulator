package com.aquirozc.jxinputemulator;

import com.sun.jna.Pointer;

public class VirtualDS4 extends VirtualController{
	
	private DS4BasicReport report = new DS4BasicReport();

	public VirtualDS4(ViGEmClient client) {
		super(client);
	}
	
	/*
	 * Reverts the current report 
	 * to neutral state.
	 */
	
	public void resetReport() {
		 report.bThumbLX = 0;
		 report.bThumbLY = 0;
		 report.bThumbRX = 0;
		 report.bThumbRY = 0;
		 report.wButtons = 0;
		 report.bSpecial = 0;
		 report.bTriggerL = 0;
		 report.bTriggerR = 0;
	}
	
	/*
	 * Presses a button (no effect if already pressed)
	 * @param DS4Button instance
	 */
	
	public void pressButton(DS4Button button) {
		report.wButtons = report.wButtons | button.flag ;
	}
	
	/*
	 *  Releases a button (no effect if already released)
	 *  @param DS4Button instance
	 */
	
	public void releaseButton(DS4Button button) {
		report.wButtons = report.wButtons & ~button.flag;
	}
	
	/*
	 * Presses a special button (no effect if already pressed)
	 * @param DS4SpecialButton instance
	 */
	
	public void pressSpecialButton(DS4Button button) {
		report.wButtons = report.bSpecial | button.flag ;
	}
	
	/*
	 *  Releases a special button (no effect if already released)
	 *  @param DS4SpecialButton instance
	 */
	
	public void releaseSpecialButton(XUSBButton button) {
		report.wButtons = report.bSpecial & ~button.flag;
	}
	
	/*
	 * Sets the value of the left trigger
     * @param Integer between 0 and 255 (0 = trigger released)
	 */
	
	public void setLeftTrigger(int value) {
		
		if(value < 0 || value > 255) {
			throw new IllegalArgumentException("Input must be an integer between 0 and 255. But was " + value);
		}
		
		report.bTriggerL = value;
	}
	
	/*
	 * Sets the value of the right trigger
     * @param Integer between 0 and 255 (0 = trigger released)
	 */
	
	public void setRightTrigger(int value) {
		
		if(value < 0 || value > 255) {
			throw new IllegalArgumentException("Input must be an integer between 0 and 255. But was " + value);
		}
		
		report.bTriggerR= value;
	}
	
	/*
	 * Sets the value of the left trigger as a percentage
     * @param Float between 0 and 1 (0 = trigger released)
	 */
	
	public void setLeftTrigger(float value) {
		
		if(value < 0 || value > 1) {
			throw new IllegalArgumentException("Input must be a float between 0 and 1. But was " + value);
		}
		
		report.bTriggerL = Math.round(255* value);
	}
	
	/*
	 * Sets the value of the right trigger as a percentage
     * @param Float between 0 and 1 (0 = trigger released)
	 */
	
	public void setRightTrigger(float value) {
		
		if(value < 0 || value > 1) {
			throw new IllegalArgumentException("Input must be a float between 0 and 1. But was " + value);
		}
		
		report.bTriggerR = Math.round(255* value);
	}
	
	/*
	 * Sets the values of the X and Y axis for the left joystick
     * @param Integer between 0 and 255 (128 = neutral position)
     * @param Integer between 0 and 255 (128 = neutral position)
	 */
	
	public void setLeftJoystick(int x, int y) {
		
		if(x< 0 || x > 255) {
			throw new IllegalArgumentException("X value must be an integer between 0 and 255. But was " + x);
		}
		
		if(y< 0 || y > 255) {
			throw new IllegalArgumentException("Y value must be an integer between 0 and 255. But was " + y);
		}
		
		report.bThumbLX = x;
		report.bThumbLY = y;
	}
	
	/*
	 * Sets the values of the X and Y axis for the right joystick
     * @param Integer between 0 and 255 (0 = neutral position)
     * @param Integer between 0 and 255 (128 = neutral position)
	 */
	
	public void setLRightJoystick(int x, int y) {
		
		if(x< 0 || x > 255) {
			throw new IllegalArgumentException("X value must be an integer between 0 and 255. But was " + x);
		}
		
		if(y< 0 || y > 255) {
			throw new IllegalArgumentException("Y value must be an integer between 0 and 255. But was " + y);
		}
		
		report.bThumbRX = x;
		report.bThumbRY = y;
	}
	
	/*
	 * Sets the values of the X and Y axis for the left joystick as percentages
     * @param Float between -1.0 and 1.0 (0 = neutral position)
     * @param Float between -1.0 and 1.0 (0 = neutral position)
	 */
	
	public void setLeftJoystick(float x, float y) {
		
		if(x< -1 || x > 1) {
			throw new IllegalArgumentException("X value must be an integer between -1 and 1. But was " + x);
		}
		
		if(y< -1 || y > 1) {
			throw new IllegalArgumentException("Y value must be an integer between -1 and 1. But was " + y);
		}
		
		report.bThumbLX = 128 + Math.round(x * 127);
		report.bThumbLY = 128 + Math.round(y * 127);
	}
	
	/*
	 * Sets the values of the X and Y axis for the right joystick as percentages
     * @param Float between -1.0 and 1.0 (0 = neutral position)
     * @param Float between -1.0 and 1.0 (0 = neutral position)
	 */
	
	public void setLRightJoystick(float x, float y) {
		
		if(x< -1 || x > 1) {
			throw new IllegalArgumentException("X value must be an integer between 0 and 255. But was " + x);
		}
		
		if(y< -1 || y > 1) {
			throw new IllegalArgumentException("Y value must be an integer between 0 and 255. But was " + y);
		}
		
		report.bThumbRX = 128 + Math.round(x * 127);
		report.bThumbRY = 128 + Math.round(y * 127);
	}
	
	/*
	 * Sends the current state of the report to the Virtual Controller,
	 * generating the desired inputs into the target system.
	 */
	
	public void update() {
		client.vigem_target_ds4_update(bus, device, report);
	}

	@Override
	public Pointer allocateTarget() {
		return client.vigem_target_ds4_alloc();
	}

}

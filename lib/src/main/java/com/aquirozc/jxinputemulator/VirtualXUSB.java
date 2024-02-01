package com.aquirozc.jxinputemulator;

import com.sun.jna.Pointer;

public class VirtualXUSB extends VirtualController implements AutoCloseable{
	
	private XUSBReport report = new XUSBReport();

	public VirtualXUSB(ViGEmClient client) {
		super(client);
	}
	
	/*
	 * Reverts the current report 
	 * to neutral state.
	 */
	
	public void resetReport() {
		report.wButtons = 0;
		report.bLeftTrigger = 0;
		report.bRightTrigger = 0;
		report.sThumbLX = 0;
		report.sThumbLY = 0;
		report.sThumbRX = 0;
		report.sThumbRY = 0;
	}
	
	/*
	 * Presses a button (no effect if already pressed)
	 * @param XUSBButton instance
	 */
	
	public void pressButton(XUSBButton button) {
		report.wButtons = report.wButtons | button.flag ;
	}
	
	/*
	 *  Releases a button (no effect if already released)
	 *  @param XUSBButton instance
	 */
	
	public void releaseButton(XUSBButton button) {
		report.wButtons = report.wButtons & ~button.flag;
	}
	
	/*
	 * Sets the value of the left trigger
     * @param Integer between 0 and 255 (0 = trigger released)
	 */
	
	public void setLeftTrigger(int value) {
		
		if(value < 0 || value > 255) {
			throw new IllegalArgumentException("Input must be an integer between 0 and 255. But was " + value);
		}
		
		report.bLeftTrigger = value;
	}
	
	/*
	 * Sets the value of the right trigger
     * @param Integer between 0 and 255 (0 = trigger released)
	 */
	
	public void setRightTrigger(int value) {
		
		if(value < 0 || value > 255) {
			throw new IllegalArgumentException("Input must be an integer between 0 and 255. But was " + value);
		}
		
		report.bRightTrigger = value;
	}
	
	/*
	 * Sets the value of the left trigger as a percentage
     * @param Float between 0 and 1 (0 = trigger released)
	 */
	
	public void setLeftTrigger(float value) {
		
		if(value < 0 || value > 1) {
			throw new IllegalArgumentException("Input must be a float between 0 and 1. But was " + value);
		}
		
		report.bLeftTrigger = Math.round(255* value);
	}
	
	/*
	 * Sets the value of the right trigger as a percentage
     * @param Float between 0 and 1 (0 = trigger released)
	 */
	
	public void setRightTrigger(float value) {
		
		if(value < 0 || value > 1) {
			throw new IllegalArgumentException("Input must be a float between 0 and 1. But was " + value);
		}
		
		report.bRightTrigger = Math.round(255* value);
	}
	
	/*
	 * Sets the values of the X and Y axis for the left joystick
     * @param Integer between -32768 and 32767 (0 = neutral position)
	 */
	
	public void setLeftJoystick(short x, short y) {
		report.sThumbLX = x;
		report.sThumbLY = y;
	}
	
	/*
	 * Sets the values of the X and Y axis for the right joystick
     * @param Integer between -32768 and 32767 (0 = neutral position)
	 */
	
	public void setLRightJoystick(short x, short y) {
		report.sThumbRX = x;
		report.sThumbRY = y;
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
		
		report.sThumbLX = Math.round(x * Short.MAX_VALUE);
		report.sThumbLY = Math.round(y * Short.MAX_VALUE);
	}
	
	/*
	 * Sets the values of the X and Y axis for the right joystick as percentages
     * @param Float between -1.0 and 1.0 (0 = neutral position)
     * @param Float between -1.0 and 1.0 (0 = neutral position)
	 */
	
	public void setLRightJoystick(float x, float y) {
		
		if(x< -1 || x > 1) {
			throw new IllegalArgumentException("X value must be an integer between -1 and 1. But was " + x);
		}
		
		if(y< -1 || y > 1) {
			throw new IllegalArgumentException("Y value must be an integer between -1 and 1. But was " + y);
		}
		
		report.sThumbRX = Math.round(x * Short.MAX_VALUE);
		report.sThumbRY = Math.round(y * Short.MAX_VALUE);
	}
	
	/*
	 * Sends the current state of the report to the Virtual Controller,
	 * generating the desired inputs into the target system.
	 */
	
	public void update() {
		client.vigem_target_x360_update(bus,device,report);
	}
	
	/*
	 * Registers a callback function that can handle force feedback, leds, etc.
	 * @param ViGEmClient.Callback handler
	 */
	
	public void registerNotification(ViGEmClient.Callback callback) {
		client.vigem_target_x360_register_notification(bus, device, callback, null);
	}
	
	/*
	 * Unregisters a previously registered callback function.
	 */
	
	public void unregisterNotification() {
		client.vigem_target_x360_unregister_notification(device);
	}
	
	/*
	 * @return: The pointer to an allocated ViGEm device;
	 */

	@Override
	public Pointer allocateTarget() {
		return client.vigem_target_x360_alloc();
	}

	@Override
	public void close() throws Exception {
		this.remove();
		
	}
	

}

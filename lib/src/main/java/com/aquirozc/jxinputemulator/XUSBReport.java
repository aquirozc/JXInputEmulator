package com.aquirozc.jxinputemulator;

import com.sun.jna.Structure;

public class XUSBReport extends Structure{
	
	public int wButtons = 0;
    public float bLeftTrigger = 0;
    public float bRightTrigger = 0;
    public int sThumbLX = 0;
    public int sThumbLY = 0;
    public int sThumbRX = 0;
    public int sThumbRY = 0;

}

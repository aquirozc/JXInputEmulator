package com.aquirozc.jxinputemulator;

import com.sun.jna.Structure;
import java.util.List;
import java.util.Arrays;

public class XUSBReport extends Structure{
	
	public int wButtons = 0;
    public int bLeftTrigger = 0;
    public int bRightTrigger = 0;
    public int sThumbLX = 0;
    public int sThumbLY = 0;
    public int sThumbRX = 0;
    public int sThumbRY = 0;

    @Override
        protected List getFieldOrder() {
            return Arrays.asList("wButtons", "bLeftTrigger", "bRightTrigger", "sThumbLX", "sThumbLY", "sThumbRX", "sThumbRY");
        }

    public static class ByReference extends XUSBReport implements Structure.ByReference {}

}

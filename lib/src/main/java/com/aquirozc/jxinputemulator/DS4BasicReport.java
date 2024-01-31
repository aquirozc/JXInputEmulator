package com.aquirozc.jxinputemulator;

import com.sun.jna.Structure;
import java.util.List;
import java.util.Arrays;

public class DS4BasicReport extends Structure {
	
	 public int bThumbLX = 0;
	 public int bThumbLY = 0;
	 public int bThumbRX = 0;
	 public int bThumbRY = 0;
	 public int wButtons = 0;
	 public int bSpecial = 0;
	 public int bTriggerL = 0;
	 public int bTriggerR = 0;
	
	@Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("bThumbLX", "bThumbLY", "bThumbRX", "bThumbRY", "wButtons", "bSpecial", "bTriggerL", "bTriggerR");
    }

    public static class ByReference extends DS4BasicReport implements Structure.ByReference {}

}

package com.aquirozc.jxinputemulator;

public enum DS4DPadDirection {
	
	DS4_BUTTON_DPAD_NONE(0x8),
    DS4_BUTTON_DPAD_NORTHWEST(0x7),
    DS4_BUTTON_DPAD_WEST(0x6),
    DS4_BUTTON_DPAD_SOUTHWEST(0x5),
    DS4_BUTTON_DPAD_SOUTH(0x4),
    DS4_BUTTON_DPAD_SOUTHEAST(0x3),
    DS4_BUTTON_DPAD_EAST(0x2),
    DS4_BUTTON_DPAD_NORTHEAST(0x1),
    DS4_BUTTON_DPAD_NORTH(0x0);
	
	public final int flag;
	
	private DS4DPadDirection(int flag) {
		this.flag = flag;	
	}

}

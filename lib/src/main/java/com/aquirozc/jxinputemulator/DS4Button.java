package com.aquirozc.jxinputemulator;

public enum DS4Button {
	
	DS4_BUTTON_THUMB_RIGHT(1 << 15),
    DS4_BUTTON_THUMB_LEFT(1 << 14),
    DS4_BUTTON_OPTIONS(1 << 13),
    DS4_BUTTON_SHARE(1 << 12),
    DS4_BUTTON_TRIGGER_RIGHT(1 << 11),
    DS4_BUTTON_TRIGGER_LEFT(1 << 10),
    DS4_BUTTON_SHOULDER_RIGHT(1 << 9),
    DS4_BUTTON_SHOULDER_LEFT(1 << 8),
    DS4_BUTTON_TRIANGLE(1 << 7),
    DS4_BUTTON_CIRCLE(1 << 6),
    DS4_BUTTON_CROSS(1 << 5),
    DS4_BUTTON_SQUARE(1 << 4);
	
	public final int flag;
	
	private DS4Button(int flag) {
		this.flag = flag;	
	}

}

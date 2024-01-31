package com.aquirozc.jxinputemulator;

public enum DS4SpecialButton {
	
	DS4_SPECIAL_BUTTON_PS(1 << 0),
	DS4_SPECIAL_BUTTON_TOUCHPAD (1 << 1);
	
	public final int flag;
	
	private DS4SpecialButton(int flag) {
		this.flag = flag;	
	}

}

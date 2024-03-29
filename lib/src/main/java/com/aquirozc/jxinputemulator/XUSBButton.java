package com.aquirozc.jxinputemulator;

public enum XUSBButton {
    
    XUSB_GAMEPAD_DPAD_UP(0x0001),
    XUSB_GAMEPAD_DPAD_DOWN(0x0002),
    XUSB_GAMEPAD_DPAD_LEFT(0x0004),
    XUSB_GAMEPAD_DPAD_RIGHT(0x0008),
    XUSB_GAMEPAD_START(0x0010),
    XUSB_GAMEPAD_BACK(0x0020),
    XUSB_GAMEPAD_LEFT_THUMB(0x0040),
    XUSB_GAMEPAD_RIGHT_THUMB(0x0080),
    XUSB_GAMEPAD_LEFT_SHOULDER(0x0100),
    XUSB_GAMEPAD_RIGHT_SHOULDER(0x0200),
    XUSB_GAMEPAD_GUIDE(0x0400),
    XUSB_GAMEPAD_A(0x1000),
    XUSB_GAMEPAD_B(0x2000),
    XUSB_GAMEPAD_X(0x4000),
    XUSB_GAMEPAD_Y(0x8000);

    public final int flag;

    private XUSBButton(int flag){
        this.flag = flag;
    }

}

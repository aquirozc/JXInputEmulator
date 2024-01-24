package com.aquirozc.jxinputemulator;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;

public interface ViGEmClient{
	
	Pointer vigem_alloc();
    void vigem_free(Pointer vigem);
    int vigem_connect(Pointer vigem);
    void vigem_disconnect(Pointer vigem);
    Pointer vigem_target_x360_alloc();
    Pointer vigem_target_ds4_alloc();
    void vigem_target_free(Pointer target);
    int vigem_target_add(Pointer vigem, Pointer target);
    int vigem_target_remove(Pointer vigem, Pointer target);
    void vigem_target_set_vid(Pointer target, short vid);
    void vigem_target_set_pid(Pointer target, short pid);
    short vigem_target_get_vid(Pointer target);
    short vigem_target_get_pid(Pointer target);
    int vigem_target_x360_update(Pointer vigem, Pointer target, XUSBReport report);
    long vigem_target_get_index(Pointer target);
    int vigem_target_get_type(Pointer target);
    boolean vigem_target_is_attached(Pointer target);
    int vigem_target_x360_get_user_index(Pointer vigem, Pointer target, IntByReference index);
    int vigem_target_x360_register_notification(Pointer vigem, Pointer target, Callback notification, Pointer userData);
    void vigem_target_x360_unregister_notification(Pointer target);
    
    interface Callback extends StdCallLibrary.StdCallCallback {
        void invoke(Pointer target, int notify, Pointer userData);
    }
    
}

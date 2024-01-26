package com.aquirozc.jxinputemulator;

import com.sun.jna.Pointer;

public abstract class VirtualController {
	
	protected Pointer bus;
	protected Pointer device;
	protected ViGEmClient client;
	
	public VirtualController(ViGEmClient client) {
		
		this.client = client;
		this.bus = new VirtualBus(client).getBus();
		this.device = allocateTarget();
		
		this.client.vigem_target_add(bus,device);
		
	}
	
	public long getIndex() {
		return client.vigem_target_get_index(device);
	}
	
	public void setProductID(short id) {
		client.vigem_target_set_pid(device, id);
	}
	
	public short  getProductID() {
		return client.vigem_target_get_pid(device);
	}
	
	public void setVendorID(short id) {
		client.vigem_target_set_vid(device, id);
	}
	
	public short getVendorID() {
		return client.vigem_target_get_vid(device);
	}
	
	public void remove() {
		client.vigem_target_remove(bus, device);
		client.vigem_target_free(device);
	}
	
	public abstract Pointer allocateTarget();

}



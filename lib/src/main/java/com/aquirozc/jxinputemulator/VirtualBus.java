package com.aquirozc.jxinputemulator;

import com.sun.jna.Pointer;

public class VirtualBus{
	
	private ViGEmClient client;
	private Pointer bus;
	
	public VirtualBus(ViGEmClient client) {
		this.client = client;
		this.bus = client.vigem_alloc();
		client.vigem_connect(bus);
	}
	
	public Pointer getBus() {
		return bus;
	}


	public void disconnect() {
		client.vigem_disconnect(bus);
		client.vigem_free(bus);
	}

}

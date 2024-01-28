package com.aquirozc.jxinputemulator;

import com.sun.jna.Pointer;

/*
 * This abstract class represents a virtual controller that can be used to emulate the input of a game device.
 * 
 * @author Alejandro Quiroz Carmona
 */

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
	
	/*
	 * Returns a 25 digit long unique number
	 * identifying the single virtual device.
	 * 
	 * @return The Serial Number of the virtual device
	 * 
	 */
	
	public long getSerialNumber() {
		return client.vigem_target_get_index(device);
	}
	
	/*
	 * Updates the unique three-byte IEEE-registered
	 * product code identifying 
	 * the specific virtual device.
	 * 
	 * @param The Product Identifier of the virtual adapter. 
	 * 
	 */
	
	public void setProductID(short id) {
		client.vigem_target_set_pid(device, id);
	}
	
	/*
	 * Returns an unique three-byte IEEE-registered 
	 * product code identifying the 
	 * specific virtual device.
	 * 
	 * @return The product id of the virtual adapter. 
	 * 
	 */
	
	public short getProductID() {
		return client.vigem_target_get_pid(device);
	}
	
	/* 
	 * Updates the unique three-byte IEEE-registered
	 * vendor code identifying the manufacturer 
	 * of the virtual device.
	 * 
	 * @param The Vendor Identifier of the virtual adapter
	 * @see <a href="https://learn.microsoft.com/en-us/windows-hardware/drivers/network/oid-gen-vendor-id">Microsoft Learn</a>
	 * 
	 */
	
	public void setVendorID(short id) {
		client.vigem_target_set_vid(device, id);
	}
	
	/* 
	 * Returns an unique three-byte IEEE-registered
	 * vendor code identifying the manufacturer 
	 * of the virtual device.
	 * 
	 * @return The Vendor Identifier of the virtual adapter
	 * @see <a href="https://learn.microsoft.com/en-us/windows-hardware/drivers/network/oid-gen-vendor-id">Microsoft Learn</a>
	 * 
	 */
	
	public short getVendorID() {
		return client.vigem_target_get_vid(device);
	}
	
	/*
	 * Removes virtual device from virtual 
	 * dedicated bus and frees corresponding
	 * resources from system memory.
	 */
	
	public void remove() {
		client.vigem_target_remove(bus, device);
		client.vigem_target_free(device);
	}
	
	public abstract Pointer allocateTarget();

}



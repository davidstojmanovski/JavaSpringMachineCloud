package com.cloud.raf.machine;



import lombok.Data;

@Data
public class MachineModel {

	private String status;
	private String uid;
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	
	
}

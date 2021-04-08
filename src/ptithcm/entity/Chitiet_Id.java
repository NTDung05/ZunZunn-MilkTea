package ptithcm.entity;

import java.io.Serializable;
import java.lang.Integer;


public class Chitiet_Id implements Serializable{

	private Integer maHD;
	
	private TraSua maTS;

	

	public TraSua getMaTS() {
		return maTS;
	}

	public void setMaTS(TraSua maTS) {
		this.maTS = maTS;
	}

	

	public Integer getMaHD() {
		return maHD;
	}

	public void setMaHD(Integer maHD) {
		this.maHD = maHD;
	}

	public Chitiet_Id(Integer maHD, TraSua maTS) {
		super();
		this.maHD = maHD;
		this.maTS = maTS;
	}

	public Chitiet_Id() {
		super();
	}
	
	
}

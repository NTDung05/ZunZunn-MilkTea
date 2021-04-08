package ptithcm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CHITIETBill")
@IdClass(Chitiet_Id.class)
public class CHITIETBill {
@Id

@Column(name="maHD")
private Integer maHD;

@Id
@ManyToOne
@JoinColumn(name= "maTS")
private TraSua maTS;
	
	@Column(name="soluong")
private Integer soluong;

	public Integer getMaHD() {
		return maHD;
	}

	public void setMaHD(Integer maHD) {
		this.maHD = maHD;
	}

	public TraSua getMaTS() {
		return maTS;
	}

	public void setMaTS(TraSua maTS) {
		this.maTS = maTS;
	}

	public Integer getSoluong() {
		return soluong;
	}

	public void setSoluong(Integer soluong) {
		this.soluong = soluong;
	}

	public CHITIETBill() {
		super();
	}

	public CHITIETBill(Integer maHD, TraSua maTS, Integer soluong) {
		super();
		this.maHD = maHD;
		this.maTS = maTS;
		this.soluong = soluong;
	}

	


	
	
	
}

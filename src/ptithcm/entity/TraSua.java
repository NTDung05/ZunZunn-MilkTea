package ptithcm.entity;


import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TraSua")
public class TraSua {
@Id
@Column(name="MaTS")
	private String maTS;

@Column(name="TenTS")
	private String tenTS;

@Column(name="Gia")
	private int Gia;
@ManyToOne
@JoinColumn(name="IdSize")	
	private Size size;     //sai o day 
@Column(name="TrangThai")	
	private int trangthai;
@Column(name="HinhAnh")	
private String hinhanh;

@OneToMany(mappedBy="maTS",fetch=FetchType.EAGER)
private Collection<CHITIETBill> chitiet;

public String getMaTS() {
	return maTS;
}

public void setMaTS(String maTS) {
	this.maTS = maTS;
}

public String getTenTS() {
	return tenTS;
}

public void setTenTS(String tenTS) {
	this.tenTS = tenTS;
}

public int getGia() {
	return Gia;
}

public void setGia(int gia) {
	Gia = gia;
}

public Size getSize() {
	return size;
}

public void setSize(Size size) {
	this.size = size;
}

public int getTrangthai() {
	return trangthai;
}

public void setTrangthai(int trangthai) {
	this.trangthai = trangthai;
}

public String getHinhanh() {
	return hinhanh;
}

public void setHinhanh(String hinhanh) {
	this.hinhanh = hinhanh;
}

public Collection<CHITIETBill> getChitiet() {
	return chitiet;
}

public void setChitiet(Collection<CHITIETBill> chitiet) {
	this.chitiet = chitiet;
}

public TraSua(String maTS, String tenTS, int gia, Size size, int trangthai, String hinhanh,
		Collection<CHITIETBill> chitiet) {
	super();
	this.maTS = maTS;
	this.tenTS = tenTS;
	Gia = gia;
	this.size = size;
	this.trangthai = trangthai;
	this.hinhanh = hinhanh;
	this.chitiet = chitiet;
}

public TraSua() {
	super();
}



}

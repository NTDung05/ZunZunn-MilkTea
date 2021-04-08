package ptithcm.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Bill")
public class Bill {
    @Id
    @GeneratedValue
	@Column(name="MaHD")
	private Integer maHD;


	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngayTao;
	
	@Column(name="TongGia")
	private int tongGia;
	

	
	@ManyToOne
	@JoinColumn(name="TaiKhoan")
	private TaiKhoan taikhoan;
	
@Column(name="TrangThai")
private int trangthai;



public Integer getMaHD() {
	return maHD;
}

public void setMaHD(Integer maHD) {
	this.maHD = maHD;
}

public Date getNgayTao() {
	return ngayTao;
}

public void setNgayTao(Date ngayTao) {
	this.ngayTao = ngayTao;
}

public int getTongGia() {
	return tongGia;
}

public void setTongGia(int tongGia) {
	this.tongGia = tongGia;
}

public TaiKhoan getTaikhoan() {
	return taikhoan;
}

public void setTaikhoan(TaiKhoan taikhoan) {
	this.taikhoan = taikhoan;
}

public int getTrangthai() {
	return trangthai;
}

public void setTrangthai(int trangthai) {
	this.trangthai = trangthai;
}



public Bill(Integer maHD, Date ngayTao, int tongGia, TaiKhoan taikhoan, int trangthai) {
	super();
	this.maHD = maHD;
	this.ngayTao = ngayTao;
	this.tongGia = tongGia;
	this.taikhoan = taikhoan;
	this.trangthai = trangthai;
}

public Bill() {
	super();
}


	
}

package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class TaiKhoan {

	@Id
	@GeneratedValue
	@Column(name="TaiKhoan")
	private int taikhoan;
	
	@Column(name="TenNV")
	private String tenNV;
	
	@Column(name="Sdt")
	private String sdt;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Quyen")
	private int quyen;
	
	@Column(name="MatKhau")
	private String matkhau;
	
	@OneToMany(mappedBy="taikhoan",fetch=FetchType.EAGER)
	private Collection<Bill> bills;

	public int getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(int taikhoan) {
		this.taikhoan = taikhoan;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getQuyen() {
		return quyen;
	}

	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public Collection<Bill> getBills() {
		return bills;
	}

	public void setBills(Collection<Bill> bills) {
		this.bills = bills;
	}

	public TaiKhoan(int taikhoan, String tenNV, String sdt, String email, int quyen, String matkhau,
			Collection<Bill> bills) {
		super();
		this.taikhoan = taikhoan;
		this.tenNV = tenNV;
		this.sdt = sdt;
		this.email = email;
		this.quyen = quyen;
		this.matkhau = matkhau;
		this.bills = bills;
	}

	public TaiKhoan() {
		super();
	}
	
}

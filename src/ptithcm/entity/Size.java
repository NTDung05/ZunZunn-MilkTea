package ptithcm.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Size")
public class Size {

	@Id
	@Column(name="IdSize")
	private int idSize;
	
	@Column(name="Size")
	private String size;

	@OneToMany(mappedBy="size",fetch=FetchType.EAGER)
	private Collection<TraSua> products;
	
	public Collection<TraSua> getProducts() {
		return products;
	}

	public void setProducts(Collection<TraSua> products) {
		this.products = products;
	}

	public int getIdSize() {
		return idSize;
	}

	public void setIdSize(int idSize) {
		this.idSize = idSize;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Size(int idSize, String size) {
		super();
		this.idSize = idSize;
		this.size = size;
	}

	public Size() {
		super();
	}
	
	
}

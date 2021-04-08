package ptithcm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ptithcm.entity.*; 
@Controller
@Transactional
@RequestMapping("/user/")
public class userController { 
	@Autowired
	SessionFactory factory;
static	TaiKhoan user = new TaiKhoan();
	private String email;
	private String tenNV;
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
//	
@RequestMapping("index")
public String show1(ModelMap model) {
	trasuaController t = new trasuaController();
	email=t.email;
	tenNV=t.tenNV;
	
	Session session = factory.getCurrentSession();
	String hql = "FROM TaiKhoan";
	Query query = session.createQuery(hql);
	List<TaiKhoan> list = query.list();
	for (TaiKhoan u : list) {
		if (u.getEmail().equals(email)) {
			user = u;
		}
	}
	System.out.println(email);
	System.out.println(tenNV);
	System.out.println(user.getMatkhau());
	System.out.println(user.getTaikhoan());
	model.addAttribute("user", user);
	return "user/index1";
}

//public TaiKhoan u() {
//	Session session = factory.getCurrentSession();
//	String hql = "FROM TaiKhoan where";
//	Query query = session.createQuery(hql);
//	List<TraSua> list = query.list();
//	
//	model.addAttribute("products", list);
//}


@RequestMapping("gallery")
public String gallery(ModelMap model) {
	Session session = factory.getCurrentSession();
	String hql = "FROM TraSua";
	Query query = session.createQuery(hql);
	List<TraSua> list = query.list();

	model.addAttribute("user", user);
	model.addAttribute("products", list);
	return"user/gallery";
}


//@RequestMapping("cart")
//public String cart(ModelMap model) {
//	model.addAttribute("user", user);
//	return"user/cart";
//}
//public TaiKhoan getTaikhoan() {
//	return taikhoan;
//}
//
//
//public void setTaikhoan(TaiKhoan taikhoan) {
//	this.taikhoan = taikhoan;
//}



@RequestMapping("about")
public String about(ModelMap model) {
	model.addAttribute("user", user);
	return"user/about";
}
@RequestMapping("contactus")
public String contactus(ModelMap model) {
	model.addAttribute("user", user);
	return"user/contact-us";
}
@RequestMapping("info/{taikhoan}")
public String updatebill(ModelMap model, @PathVariable("taikhoan") int taikhoan) {
	
	Session session = factory.openSession();
	Transaction t = session.beginTransaction();
	TaiKhoan acc = (TaiKhoan) session.get(TaiKhoan.class, taikhoan);
	
	model.addAttribute("acc", acc);
		
	return "user/info";
}



@RequestMapping(value = "info", method = RequestMethod.POST)
public String updatebill(ModelMap model, @ModelAttribute("acc") TaiKhoan acc) {

	Session session = factory.openSession();
	Transaction t = session.beginTransaction();
	try {
//	record.set(user.getPassword());
//	user.setFullname(user.getFullname());
		session.update(acc);
		t.commit();
		model.addAttribute("message", "Update thành công");
	} catch (Exception e) {
		e.printStackTrace();
		t.rollback();
		model.addAttribute("message", "Update thất bại");
	} finally {
		session.close();
	}
	return "redirect:/user/gallery.htm";
}
public TaiKhoan selectUser(String uname) {
	TaiKhoan user = null;
	Session session = factory.getCurrentSession();
	String hql = "FROM TaiKhoan";
	Query query = session.createQuery(hql);
	List<TaiKhoan> list = query.list();
	for (TaiKhoan u : list) {
		if (u.getEmail().equals(uname)) {
			user = u;
		}
	}
	return user;

}

public int selectUserId(String uname) {
	int userID = 0;
	Session session = factory.getCurrentSession();
	String hql = "from TaiKhoan";
	Query query = session.createQuery(hql);
	List<TaiKhoan> list = query.list();
	for (TaiKhoan u : list) {
		if (u.getEmail().equals(uname)) {
			userID =u.getTaikhoan();
		}
	}
	return userID;

}


}

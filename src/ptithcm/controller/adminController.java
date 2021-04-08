package ptithcm.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.entity.*;

@Controller
@Transactional
@RequestMapping("/admin/")
public class adminController {
	@Autowired
	SessionFactory factory;
	@Autowired
	JavaMailSender mailer;
	static	TaiKhoan user = new TaiKhoan();
	private String email;
	private String tenNV;
public boolean checkQuyen(String uemail) {
	boolean check = false;
	Session session = factory.getCurrentSession();
	String hql = "FROM TaiKhoan";
	Query query = session.createQuery(hql);
	List<TaiKhoan> list = query.list();
	for (TaiKhoan u : list) {
		if (u.getEmail().equals(uemail)) {
			if(u.getQuyen()==1) {
				return true;
				
			}
		}
	}
	return check;
}
@RequestMapping("")
	public String home(ModelMap model) {
		trasuaController t = new trasuaController();
      email=t.email;
      tenNV=t.tenNV;
      		if(checkQuyen(email)) {
      			return "product/index";
      		}else
return "error";
	}
	
	@RequestMapping(value = "product/index")
	public String product(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM TraSua";
		Query query = session.createQuery(hql);
		List<TraSua> list = query.list();
		
		model.addAttribute("products", list);

		return "admin/product/index";
	}

	@RequestMapping(value="product/insert", method= RequestMethod.GET)
	public String pinsert(ModelMap model) {
		TraSua dungBD = new TraSua();
		dungBD.setSize(new Size());
		model.addAttribute("product", dungBD);
		
		return "admin/product/insert";
	}

	@RequestMapping(value="product/insert",method= RequestMethod.POST)
	public String pinsert(ModelMap model, @ModelAttribute("product") TraSua product) {
	
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(product);
			t.commit();
			model.addAttribute("message", "Thêm mới thành công");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Thêm mới thất bại");
		} finally {
			session.close();
		}
		return "redirect:/admin/product/index.htm";
	}
	
	@RequestMapping(value = "product/delete/{maTS}")
	public String delete(ModelMap model, @PathVariable("maTS") String maTS) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			TraSua s = (TraSua) session.get(TraSua.class, maTS);
			session.delete(s);
			t.commit();
			model.addAttribute("message", "Xóa thành công");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Xóa thất bại");
		} finally {
			session.close();
		}
		return "redirect:/admin/product/index.htm";
	}

	@RequestMapping(value = "product/update/{maTS}")
	public String update(ModelMap model, @PathVariable("maTS") String maTS) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		TraSua p = (TraSua) session.get(TraSua.class, maTS);
		model.addAttribute("product", p);

		return "admin/product/update";
	}
	
	

	@RequestMapping(value = "product/update", method = RequestMethod.POST)
	public String update(ModelMap model, @ModelAttribute("product") TraSua product) {

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
//		record.set(user.getPassword());
//		user.setFullname(user.getFullname());
			session.update(product);
			t.commit();
			model.addAttribute("message", "Update thành công");
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			model.addAttribute("message", "Update thất bại");
		} finally {
			session.close();
		}
		return "redirect:/admin/product/index.htm";
	}

	@RequestMapping("bill/index")
	public String bill(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Bill";
		
		Query query = session.createQuery(hql);
		List<Bill> list = query.list();
		model.addAttribute("bills", list);
		return "admin/bill/index";
	}

	@RequestMapping(value = "bill/update/{maHD}")
	public String updatebill(ModelMap model, @PathVariable("maHD") int maHD) {
		String ma = String.valueOf(maHD);
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Bill b = (Bill) session.get(Bill.class, maHD);
		
		String hql ="FROM CHITIETBill detail where detail.maHD="+ma;
		Query query = session.createQuery(hql);
		List<CHITIETBill> list = query.list();
		model.addAttribute("bill", b);
				model.addAttribute("detail", list);
		return "admin/bill/detail";
	}
	
	

	@RequestMapping(value = "bill/update", method = RequestMethod.POST)
	public String updatebill(ModelMap model, @ModelAttribute("bill") Bill bill, HttpServletRequest request) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		int trangthai = bill.getTrangthai();
      int id = Integer.parseInt(request.getParameter("taikhoan.taikhoan"));
        int mahd = bill.getMaHD();
        int tongtien=bill.getTongGia();
        String mail="";
        String hql ="FROM TaiKhoan u where u.taikhoan="+id;
		Query query = session.createQuery(hql);
		List<TaiKhoan> list = query.list();
		for(TaiKhoan u : list) {
			if(u.getTaikhoan()==id) {
				mail = u.getEmail();
			}
		}
        System.out.println(trangthai+ mail+mahd+tongtien);
        Session session1 = factory.openSession();
		Transaction t1 = session1.beginTransaction();
		try {	
			
			session1.update(bill);
			t1.commit();
			model.addAttribute("message", "Update thành công");
			
			   System.out.println(trangthai+ mail+mahd+tongtien);
			if(trangthai==0) {
				sendMail(mail, mahd, tongtien);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			t1.rollback();
			model.addAttribute("message", "Update thất bại");
		} finally {
			session1.close();
			session.close();
		}
		return "redirect:/admin/bill/index.htm";
	}
	
	@RequestMapping("user/index")
	public String account(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM TaiKhoan";
		Query query = session.createQuery(hql);
		List<TaiKhoan> list = query.list();
		model.addAttribute("users", list);
		return "admin/user/index";
	}
	
	@RequestMapping(value = "user/delete/{taikhoan}")
	public String delete(ModelMap model, @PathVariable("taikhoan") int taikhoan) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			TaiKhoan s = (TaiKhoan) session.get(TaiKhoan.class, taikhoan);
			s.setQuyen(-1);
			session.update(s);
			t.commit();
			model.addAttribute("message", "Xóa thành công");
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Xóa thất bại");
		} finally {
			session.close();
		}
		return "redirect:/admin/user/index.htm";
	}
	
	public void sendMail(String mailClient, int maHD , int tongtien) {
		boolean check = true;
		String body = "Đơn hàng mã số "+maHD+" của bạn đã được xác nhận. Tổng Tiền của hóa đơn là "+tongtien+"VND";
				String from="ntdung05101999@gmail.com";
		
		try{
			MimeMessage mail = mailer.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setFrom(from, from);
			helper.setTo(mailClient);
			helper.setReplyTo(from, from);
			helper.setSubject("Thông báo xác nhận đơn hàng!");
			helper.setText(body, true);

			mailer.send(mail);
		}
		catch(Exception e){
			check = false;
		}
		
	}
}

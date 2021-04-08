package ptithcm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import ptithcm.entity.*; 
@Controller
@Transactional
@RequestMapping("/TRASUA/")
public class trasuaController {
	@Autowired
	JavaMailSender mailer;
	@Autowired
	SessionFactory factory;
	@Autowired
	javax.servlet.ServletContext context;
	
	TaiKhoan taikhoan= new TaiKhoan();
	public static String email;
	public static String tenNV;
	
	



@RequestMapping("index")
	public String show(HttpSession session) {
	
	HashMap<String, TraSua> cartdetail = (HashMap<String, TraSua>) session.getAttribute("cartdetail");
	HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");
	session.removeAttribute("cartdetail");
	session.removeAttribute("cart");	
		return"index1";
	}


@RequestMapping(value="login", method = RequestMethod.GET)
public String login(HttpServletRequest request, ModelMap model) throws ServletException, IOException {
    model.addAttribute("USER", new TaiKhoan());
    return "login";
  } 



@RequestMapping(value = "login", method = RequestMethod.POST)
public String login(@ModelAttribute("USER") TaiKhoan user, HttpServletRequest request, ModelMap model,
		BindingResult errors) throws ServletException, IOException {
	Session session = factory.getCurrentSession();
	String hql = "FROM TaiKhoan";
	Query query = session.createQuery(hql);
	List<TaiKhoan> listAcc = query.list();
	if (user.getEmail().trim().length() == 0) {
		errors.rejectValue("email", "USER", "Vui lòng email đăng nhập !!!");
	}
	if (user.getMatkhau().trim().length() == 0) {
		errors.rejectValue("matkhau", "USER", "Vui lòng nhập mật khẩu !!!");
	}
	if (errors.hasErrors()) {
		model.addAttribute("message", "Vui lòng nhập thông tin người dùng !!!");
	} else {
		boolean check = true;
		for (TaiKhoan ktra : listAcc) {
			if (user.getEmail().equals(ktra.getEmail())
					&& user.getMatkhau().equals(ktra.getMatkhau())
				) {

				check = false;
				String username = ktra.getEmail();
				HttpSession s = request.getSession();
				s.setAttribute("username", ktra.getEmail());
//		        s.setAttribute("count", countProd(ktra.getAccount_name()));
				if (ktra.getQuyen() == 1) {
					return "redirect:/admin/product/index.htm";
				}else
				{  
					email = ktra.getEmail();
					tenNV = ktra.getTenNV();
					model.addAttribute("user", ktra);
					return "redirect:/user/index.htm";
				}
				
					
			}
		}
		if (check == true) {
			model.addAttribute("message", "Tên tài khoản hoặc mật khẩu chưa đúng !!!");
		} 
			
		
	}

	return "login";
}
//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//}
//
//public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
//	try {
//		
//		
//		HttpSession session = request.getSession();
//		session.setAttribute("email", email);
//		session.setAttribute("tenNV", tenNV);
//	}catch(Exception e) {
//		System.out.println(e);
//	}
//}
@RequestMapping(value = "register")
public String register(ModelMap model) throws ServletException, IOException {
	model.addAttribute("USER", new TaiKhoan());
	return "register";
}


@RequestMapping(value = "register", method = RequestMethod.POST)
public String register(@ModelAttribute("USER") TaiKhoan user, BindingResult errors, HttpServletRequest request, ModelMap model)
		throws ServletException, IOException {
	//String pass_= request.getParameter("PASS");
	Session s = factory.openSession();
	Transaction t = s.beginTransaction();
	boolean check = true;
	String hql = "FROM TaiKhoan";
	Query query = s.createQuery(hql);
	List<TaiKhoan> listAcc = query.list();
	
	if(user.getTenNV().trim().length() == 0) {
		errors.rejectValue("tenNV", "USER", "Vui lòng nhập tên người dùng!");
	}		
	
	
	if(user.getEmail().trim().length() == 0) {
		errors.rejectValue("email", "USER", "Vui lòng nhập Email!");
	}
	
	if(user.getMatkhau().trim().length() == 0) {
		errors.rejectValue("matkhau", "USER", "Vui lòng nhập mật khẩu!");
	}
	if(user.getSdt().trim().length() == 0) {
		errors.rejectValue("sdt", "USER", "Vui lòng nhập số điện thoại!");
	}
	
//	if(user.getMatkhau().equals(pass_) == false) {
//		errors.rejectValue("PASS", "USER", "Mật khẩu không giống nhau!");
//	}
	
	if(errors.hasErrors()) {
		model.addAttribute("message", "Vui lòng điền thông tin đầy đủ!");
		return"register";
	}
	else {
	
		for (TaiKhoan ktra : listAcc) {
			if (ktra.getEmail().equals(user.getEmail())) {
				check = false;
				errors.rejectValue("email", "USER", "Email đã đăng ký tài khoản. Bạn vui lòng sử dụng Email khác!");
				return "register";
			}
		}
		if(check == true) {
			
			user.setQuyen(0);
			s.save(user); //luu do db
			t.commit(); //chap nhan thay doi du lieu trong db
			model.addAttribute("message", true);
			return "redirect:/user/index.htm";
		}
		else {
			model.addAttribute("message", false);

		}
	}
	return "register";
}

@RequestMapping(value = "forget-pass", method = RequestMethod.GET)
public String forget(ModelMap model) throws ServletException, IOException {
	model.addAttribute("USER", new TaiKhoan());
	return "forget-pass";
}

@RequestMapping(value = "forget-pass", method = RequestMethod.POST)
public String forget(ModelMap model, @ModelAttribute("USER") TaiKhoan u, BindingResult errors) {

	Session session = factory.openSession();
	Transaction t = session.beginTransaction();
	String hql = "FROM TaiKhoan";
	Query query = session.createQuery(hql);
	List<TaiKhoan> listAcc = query.list();
	boolean check = false;
	for(TaiKhoan user: listAcc) {
		if(user.getEmail().equals(u.getEmail())) {
			int code = (int) Math.floor(((Math.random() * 8999999) + 1000000));
			String kq=String.valueOf(code);
			check = true;
			try {
				user.setMatkhau(kq);
				session.update(user);
				t.commit();
				sendMail(user.getEmail(), user.getMatkhau());
				model.addAttribute("message", true);
				
			}
			catch(Exception e) {
				t.rollback();
				model.addAttribute("message", false);
			}
			finally {
				session.close();
			}
		}
	}
	if (check == false) {
		errors.rejectValue("Email", "u", "Email chưa đăng ký!");
		return "register";
	} else {
	return "login";
	}
}

@RequestMapping("gallery")
public String gallery(ModelMap model) {
	Session session = factory.getCurrentSession();
	String hql = "FROM TraSua";
	Query query = session.createQuery(hql);
	List<TraSua> list = query.list();
	
	model.addAttribute("products", list);
	return"gallery";
}
@RequestMapping("about")
public String about() {
	return"about";
}
@RequestMapping("contactus")
public String contactus() {
	return"contact-us";
}
@RequestMapping("cart")
public String cart() {
	return"cart";
}
public TaiKhoan selectUser(String uname) {
	TaiKhoan user = null;
	Session session = factory.getCurrentSession();
	String hql = "from ACCOUNT";
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
	String hql = "from ACCOUNT";
	Query query = session.createQuery(hql);
	List<TaiKhoan> list = query.list();
	for (TaiKhoan u : list) {
		if (u.getEmail().equals(uname)) {
			userID =u.getTaikhoan();
		}
	}
	return userID;

}
public boolean sendMail(String mailClient, String pass) {
	boolean check = true;
	String body = " Đây là mật khẩu tạm thời của bạn: " + pass + ". Bạn hãy thay đổi mật khẩu sau khi đăng nhập";
			String from="ntdung05101999@gmail.com";
	
	try{
		MimeMessage mail = mailer.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail);
		helper.setFrom(from, from);
		helper.setTo(mailClient);
		helper.setReplyTo(from, from);
		helper.setSubject("Thông báo xác nhận đổi mật khẩu!");
		helper.setText(body, true);

		mailer.send(mail);
	}
	catch(Exception e){
		check = false;
	}
	return check;
}
}

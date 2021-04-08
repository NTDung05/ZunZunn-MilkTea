package ptithcm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ptithcm.entity.*;
import ptithcm.controller.*;

@Controller
@Transactional
public class Giohang {
	TaiKhoan user = new TaiKhoan();

	@Autowired
	SessionFactory factory;

	@RequestMapping("user/cart1")
	public String show(ModelMap model, HttpSession session) {
		System.out.println("hi");
		userController user1 = new userController();

		user = user1.user;
		Session session1 = factory.getCurrentSession();
		String hql = "FROM TraSua";
		Query query = session1.createQuery(hql);
		List<TraSua> list = query.list();
		System.out.println("ba");
		int tonggia = 0;
		if (session.getAttribute("cart") == null) {
			HashMap<String, Integer> cart = new HashMap<String, Integer>();
			Set<String> keySet = cart.keySet();
			HashMap<String, TraSua> cartdetail = new HashMap<String, TraSua>();

			for (String key : keySet) {
				for (TraSua t : list) {
					if (t.getMaTS().equals(key)) {
						cartdetail.put(key, t);
						tonggia += cartdetail.get(key).getGia() * cart.get(key);
					}

				}
			}
			session.setAttribute("cartdetail", cartdetail);
		} else {
			HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");
			Set<String> keySet = cart.keySet();
			HashMap<String, TraSua> cartdetail = new HashMap<String, TraSua>();

			for (String key : keySet) {
				for (TraSua t : list) {
					if (t.getMaTS().equals(key)) {
						cartdetail.put(key, t);
						tonggia += cartdetail.get(key).getGia() * cart.get(key);
					}

				}
			}
			session.setAttribute("cartdetail", cartdetail);
		}

		System.out.println(tonggia);

		model.addAttribute("tonggia", tonggia);
		model.addAttribute("user", user);

		return "user/cart"; // hinh nhu co 2 file cart, coi lay trong cai user
	}

	@RequestMapping("user/cart/{idSP}.htm")
	public void Cart(@PathVariable("idSP") String idSP, HttpSession session, HttpServletResponse rs, ModelMap model)
			throws IOException {
		System.out.println("ok");
		if (session.getAttribute("cart") == null) {
			// neu gio hang chua ton tai, thi khoi tao
			HashMap<String, Integer> cart = new HashMap<String, Integer>();// <idSP, số luong>
			// va gan cai id vua click them gio hang vo
			cart.put(idSP, 1);
			// sau do, set cart thanh vo sesshuion "cart"
			session.setAttribute("cart", cart);
		} else {
			// neu gio hang da ton tai
			HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");
			if (cart.containsKey(idSP)) {
				// neu trong gio hang da ton tai idSP nay, thi tang so luong no len 1;
				cart.replace(idSP, cart.get(idSP) + 1);
			} else {
				// nguoc lai, neu gio hang chua co thi them idSP vo voi so luong la 1.
				cart.put(idSP, 1);
			}
			session.setAttribute("cart", cart);
		}
		model.addAttribute("user", user);
		rs.sendRedirect("/DOAN/user/cart1.htm");
	}

	@RequestMapping("user/cart/delete/{idSP}.htm")
	public void deleteItem(@PathVariable("idSP") String idSP, HttpSession session, HttpServletResponse rs,
			ModelMap model) throws IOException {
		System.out.println("ok");
		if (session.getAttribute("cart") != null) {
			HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");
			cart.remove(idSP);
			session.setAttribute("cart", cart);
		}
		model.addAttribute("user", user);
		rs.sendRedirect("/DOAN/user/cart1.htm");
	}

//	
	public Bill setbill() {

		System.out.println(user.getEmail());
		Bill bill = new Bill();
		bill.setTaikhoan(user);
		bill.setNgayTao(new Date());
		bill.setTrangthai(1);
		bill.setTongGia(0);
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(bill);
			t.commit();

		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();

		} finally {
			session.close();
		}
		return bill;
	}

	@RequestMapping("user/checkout")
	public String checkout(ModelMap model, HttpSession session) {
		HashMap<String, TraSua> cartdetail = (HashMap<String, TraSua>) session.getAttribute("cartdetail");
		HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("cart");
		Set<String> keySet = cartdetail.keySet();
		Set<String> keySetcart = cart.keySet();
		Bill b = new Bill();
		b = setbill();

		System.out.println(b.getMaHD());
		List<CHITIETBill> details = new ArrayList<CHITIETBill>();

		Chitiet_Id ch = new Chitiet_Id();

//		for (String key1 : keySetcart) {
//			
//			System.out.println(key1 + cartdetail.get(key1));
//		}

//		
		int tonggia = 0;
		for (String key1 : keySetcart) { // keysetCart lay so luong key1
			for (String key : keySet) { // keySet = TraSUa lay tra sua bằng key
				if (key.equals(key1)) {
					Session session1 = factory.openSession();
					Transaction t = session1.beginTransaction();

					CHITIETBill detail = new CHITIETBill();
//					ch.setMaHD(b.getMaHD());
//					ch.setMaTS(cartdetail.get(key));

					detail.setMaHD(b.getMaHD());
					detail.setMaTS(cartdetail.get(key));
					detail.setSoluong(cart.get(key1));
					// ch.setMaTS(detail.getMaTS());
					System.out.println(detail.getSoluong());
					System.out.println(detail.getMaTS().getMaTS());
					System.out.println(detail.getMaHD());
					tonggia += (detail.getMaTS().getGia() * detail.getSoluong());
					try {
						session1.save(detail);
						t.commit();
						details.add(detail);

					} catch (Exception e) {
						e.printStackTrace();
						t.rollback();
					} finally {
						session1.close();
					}
				}

			}
		}

		b.setTongGia(tonggia);
		Session session1 = factory.openSession();
		Transaction t = session1.beginTransaction();
		try {
			session1.update(b);
			t.commit();

		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
		} finally {
			session1.close();
		}

		model.addAttribute("user", user);
		session.removeAttribute("cartdetail");
		session.removeAttribute("cart");	
		return "user/index1";
	}
}

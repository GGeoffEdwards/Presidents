package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import data.President;
import data.PresidentDAO;
import data.PresidentDAOFileImpl;

public class PresidentsServlet extends HttpServlet {

	PresidentDAO presidentDAO;

	@Override
	public void init() throws ServletException {
		presidentDAO = new PresidentDAOFileImpl(this.getServletContext());

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		Item item = storeDAO.getInventoryItem(req.getParameter("product"));
		HttpSession session = req.getSession();
		List<President> presidents = (List<President>) session.getAttribute("presidents");
		if (presidents == null) {
			presidents = new ArrayList<President>();
			session.setAttribute("presidents", presidents);
		}
		req.setAttribute("presidents", presidentDAO.getPresidents());
		req.getRequestDispatcher("/president.jsp").forward(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setAttribute("presidents", presidentDAO.getPresidents());
		req.getRequestDispatcher("/president.jsp").forward(req, resp);
	}
	
}

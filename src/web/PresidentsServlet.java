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
	List<President> presidents;
	List<President> filterPresidents;

	@Override
	public void init() throws ServletException {
		presidentDAO = new PresidentDAOFileImpl(this.getServletContext());

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Item item = storeDAO.getInventoryItem(req.getParameter("product"));
		HttpSession session = req.getSession();
		presidents = (List<President>) session.getAttribute("presidents");
		if (presidents == null) {
			presidents = new ArrayList<President>();
			session.setAttribute("presidents", presidents);
		}
		req.setAttribute("presidents", presidentDAO.getPresidents());
		req.getRequestDispatcher("/president.jsp").forward(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nextBack = req.getParameter("submit");
		String goToTerm = req.getParameter("termNumber");
		//System.out.println(nextBack);
		String filter = req.getParameter("filter");
		System.out.println("filter =" + filter);

		if (filter != null) {
			filter = " " + filter;
			filterPresidents = new ArrayList<>();
			for (President p : presidentDAO.getPresidents()) {
				if (p.getParty().equals(filter)) {
					filterPresidents.add(p);
				}
			}
			System.out.println(filterPresidents.size());
			req.setAttribute("filterPresident", filterPresidents);
			req.getRequestDispatcher("/filter.jsp").forward(req, resp);
		}

		else if (goToTerm != null) {
			int g = Integer.parseInt(goToTerm);
			//System.out.println("goToTerm" + g);
			req.setAttribute("president", presidentDAO.getPresidents().get(g - 1));
			req.setAttribute("nextNumber", Integer.parseInt(presidentDAO.getPresidents().get(g - 1).getTermNumber()));
			req.setAttribute("prevNumber",
					Integer.parseInt(presidentDAO.getPresidents().get(g - 1).getTermNumber()) - 2);
		}

		else if (nextBack == null) {
			req.setAttribute("president", presidentDAO.getPresidents().get(0));
			req.setAttribute("nextNumber", Integer.parseInt(presidentDAO.getPresidents().get(0).getTermNumber()));
		} else {
			int x = Integer.parseInt(nextBack);

			// System.out.println("test" +
			// (Integer.parseInt(presidentDAO.getPresidents().get(x).getTermNumber())
			// -2));
			req.setAttribute("president", presidentDAO.getPresidents().get(x));
			req.setAttribute("nextNumber", Integer.parseInt(presidentDAO.getPresidents().get(x).getTermNumber()));
			req.setAttribute("prevNumber", Integer.parseInt(presidentDAO.getPresidents().get(x).getTermNumber()) - 2);
		}
		req.getRequestDispatcher("/president.jsp").forward(req, resp);

	}

}

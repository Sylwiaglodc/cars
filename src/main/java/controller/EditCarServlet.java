package controller;

/**
 * @author sylw - srglod
 * CIS175 - Spring 2023
 * Feb 09, 2023
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarList;

/**
 * Servlet implementation class EditCarServlet
 */
@WebServlet("/editCarServlet")
public class EditCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CarListHelper dao =new CarListHelper();
		
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String liters = request.getParameter("liters");
		String cylinders = request.getParameter("cylinders");
		String turbo = request.getParameter("turbo");
		
		int cylinders2 = Integer.parseInt(cylinders);
		double liters2 = Double.parseDouble(liters);
		boolean turbo2 = Boolean.parseBoolean(turbo);
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		CarList itemToUpdate = dao.searchForCarById(tempId);
		
		itemToUpdate.setMake(make);
		itemToUpdate.setModel(model);
		itemToUpdate.setLiters(liters2);
		itemToUpdate.setCylinders(cylinders2);
		itemToUpdate.setTurbo(turbo2);

		dao.updateItem(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
	}

}

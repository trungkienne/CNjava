package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class TemperatureServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            double temp = Double.parseDouble(request.getParameter("temp"));
            String type = request.getParameter("type");
            double result;

            if ("CtoF".equals(type)) {
                result = temp * 9 / 5 + 32;
            } else {
                result = (temp - 32) * 5 / 9;
            }

            request.setAttribute("result", result + "");
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Giá trị nhiệt độ không hợp lệ.");
        }

        request.getRequestDispatcher("temp.jsp").forward(request, response);
    }
}

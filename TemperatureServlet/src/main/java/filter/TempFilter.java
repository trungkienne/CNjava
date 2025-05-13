package filter;

import javax.servlet.*;
import java.io.IOException;

public class TempFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String tempStr = request.getParameter("temp");
        try {
            if (tempStr != null && !tempStr.isEmpty()) {
                Double.parseDouble(tempStr);
                chain.doFilter(request, response);
                return;
            }
        } catch (NumberFormatException ignored) {}

        request.setAttribute("error", "Nhiệt độ phải là số hợp lệ!");
        request.getRequestDispatcher("temp.jsp").forward(request, response);
    }
}

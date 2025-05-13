package listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener {
    public void requestInitialized(ServletRequestEvent sre) {
        ServletContext context = sre.getServletContext();
        Integer count = (Integer) context.getAttribute("requestCount");
        if (count == null) count = 0;
        context.setAttribute("requestCount", ++count);
        System.out.println("Yêu cầu #" + count);
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        // Optional
    }
}

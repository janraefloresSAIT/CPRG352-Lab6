package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Flores
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("logout")) {
                request.setAttribute("logoutMessage", "You have successfully logged out.");
                session.invalidate();
            }
        } else {
            if (session.getAttribute("username") != null) {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                return;
            }
        }

        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        ArrayList<String> shoppingList = (ArrayList<String>) session.getAttribute("shoppingList");
        if (shoppingList == null) {
            shoppingList = new ArrayList<String>();
        }

        if (request.getParameter("usernameInput") != null) {
            String username = request.getParameter("usernameInput");
            request.setAttribute("username", username);
            session.setAttribute("username", username);
        }

        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("add")) {
                String item = request.getParameter("item");
                if (item != null && !item.equals("")) {
                    shoppingList.add(item);
                    session.setAttribute("shoppingList", shoppingList);
                }
            } else if (action.equals("delete")) {
                String deleteItem = request.getParameter("item");
                if (deleteItem != null && !deleteItem.equals("")) {
                    shoppingList.remove(deleteItem);
                    session.setAttribute("shoppingList", shoppingList);
                }
            }
        }

        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        return;
    }
}

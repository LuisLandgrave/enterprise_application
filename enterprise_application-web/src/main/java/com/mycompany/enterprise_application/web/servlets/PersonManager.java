package com.mycompany.enterprise_application.web.servlets;

import com.mycompany.enterprise_application.ejb.PersonService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PersonManager", urlPatterns = {"/PersonManager"})
public class PersonManager extends HttpServlet {

    @EJB
    private PersonService personEJB;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PersonManager</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PersonManager at " + request.getContextPath() + "</h1>");
            out.println("<hr>");

            String operation = request.getParameter("operation");

            switch (operation) {
                case "CREATE":
                    out.println("Creating person: " + request.getParameter("name"));
                    UUID id = personEJB.register(request.getParameter("name"));
                    out.println("<br>");
                    out.println("ID=" + id);
                    break;
                case "UPDATE":
                    out.println("Updating person: " + request.getParameter("name") + " (" + request.getParameter("id") + ")");
                    personEJB.update(UUID.fromString(request.getParameter("id")), request.getParameter("name"));
                    break;
                case "DELETE":
                    out.println("Deleting person: " + request.getParameter("id"));
                    personEJB.delete(UUID.fromString(request.getParameter("id")));
                    break;
                default:
                    throw new AssertionError();
            }

            out.println("</body>");
            out.println("</html>");

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}

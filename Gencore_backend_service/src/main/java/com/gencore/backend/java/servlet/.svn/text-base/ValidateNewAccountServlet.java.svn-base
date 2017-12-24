package com.gencore.backend.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.gencore.backend.java.context.AppContext;
import com.gencore.backend.java.entity.UserProfile;
import com.gencore.backend.java.exception.FlexServiceException;
import com.gencore.backend.java.service.admin.UserService;

public class ValidateNewAccountServlet  extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    private ApplicationContext context;
    private UserService userService;
    
    public ValidateNewAccountServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
        context  = AppContext.getApplicationContext();
        
        userService = (UserService) context.getBean("userServiceBean");
        
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        
        UserProfile user = null;
        
        try {
            
            user = userService.getUserByLogin(login);
            
            //Vérifier que la date de création n'est pas sup à 30jours
            
            
            if ( user.getEmail().equals( email )) {
                
                user.setEnabled(true);
                
                userService.updateUser(user);
                
            } else {
                //Gestion des erreurs
            }
            
        } catch ( NullPointerException e){
            
            System.out.println("Erreur");
        } catch (FlexServiceException e) {
            // TODO Auto-generated catch block
        }
        
        
        
        System.out.println( request.getParameter("login") );
        System.out.println( request.getParameter("email") );
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE> Votre compte est validé </TITLE></HEAD>");
        out.println("<BODY>");
        out.println(request.getParameter("login") );
        out.println("</BODY>");
        out.println("</HTML>");
        out.close();
    }
    
 


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    }

}

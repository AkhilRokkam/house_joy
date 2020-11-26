package com.ts.housejoy.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.ts.housejoy.dto.*;
import com.ts.housejoy.service.*;



@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 20)

public class HouseJoyController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String action = request.getParameter("action");
		
		

		if (action == null) {

		
		}
		
		
				

		if (action.equals("logout")) {

			
		}		
		

		if (Integer.parseInt(action) > 100 && Integer.parseInt(action) < 200) {


		}
		
		
		
		if (Integer.parseInt(action) > 1000 && Integer.parseInt(action) < 2000) {
			

		}	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		

		String action = request.getParameter("action");		
		

		if ("Login As User".equalsIgnoreCase(action)) {

			
			
		} else if ("Login As Admin".equalsIgnoreCase(action)) {					
			
			

		} else if ("Login As Force".equalsIgnoreCase(action)) {

			
		} else if ("signUpUser".equalsIgnoreCase(action)) {
			

		} else if ("signUpForce".equalsIgnoreCase(action)) {
			
			
		}
		else if(action.equalsIgnoreCase("add_address")) {						
		
				
		}		
		
		else if(action.equalsIgnoreCase("add_category")) {
			
			
		}
		else if(action.equalsIgnoreCase("add_subcategory")) {			
           
			
		}
		else if(action.equalsIgnoreCase("add_servicetype")) {			
			
		}		
	}
	
	
	private void imageUpload(HttpServletRequest request, String fname, String saveDir) throws ServletException, IOException {
		
		 String savePath = "D:/tswork/housejoy/WebContent/" + saveDir;
		 
		 
		 
		 File fileSaveDir = new File(savePath);
		 
	        if (!fileSaveDir.exists()) {
	            fileSaveDir.mkdir();
	        }
	         
	        Part part = request.getPart("file");
	        String fileName = extractFileName(part);
	       
	            // refines the fileName in case it is an absolute path
	            fileName = new File(fileName).getName();
	            System.out.println(fileName);
	            part.write(savePath + "/" + fname);       
		
	}
	
	
	 private String extractFileName(Part part) {
	        String contentDisp = part.getHeader("content-disposition");
	        String[] items = contentDisp.split(";");
	        for (String s : items) {
	            if (s.trim().startsWith("filename")) {
	                return s.substring(s.indexOf("=") + 2, s.length()-1);
	            }
	        }
	        return "";
	    }
}
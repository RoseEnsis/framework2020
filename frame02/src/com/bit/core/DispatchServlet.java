package com.bit.core;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.EmpDao;

public class DispatchServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doBit(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doBit(req,resp);
	}

	
	protected void doBit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url=req.getRequestURI();
		
		System.out.println(url);
		
		String view = "/WEB-INF/view/";
		if(url.equals("/frame02/")) {
			view+="index.jsp";
		}else if(url.equals("/frame02/intro")) {
			view+="intro.jsp";	
		}else if(url.equals("/frame02/bbs/list")) {
			EmpDao dao=new EmpDao();
			try {
				req.setAttribute("alist", dao.selectAll());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			view+="list.jsp";
		}else if(url.equals("/frame02/bbs/add")) {
			view+="add.jsp";
		}else if(url.equals("/frame02/bbs/insert")) {
			String name=req.getParameter("name");
			int pay=Integer.parseInt(req.getParameter("pay"));
			EmpDao dao=new EmpDao();
			try {
				dao.insertOne(name,pay);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			resp.sendRedirect("list");
			return;
		}else {
			return;
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req,resp);
		
	}
}

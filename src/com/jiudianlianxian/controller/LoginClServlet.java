package com.jiudianlianxian.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Title: LoginClServlet
 * Description: 登录处理
 * Company: 济宁九点连线信息技术有限公司
 * ProjectName: ServletContextTwo
 * @author fupengpeng
 * @date 2017年7月29日 上午9:08:35
 *
 */
@WebServlet("/LoginClServlet")
public class LoginClServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginClServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//接受密码
		String password = request.getParameter("password");
		
		if ("111".equals(password)) {
			out.println("登录成功");
			
			String nums = (String) this.getServletContext().getAttribute("nums");
//			if (nums == null) {
//				System.out.println("nums 1 = " + nums);
//				this.getServletContext().setAttribute("nums", "1");
//				System.out.println("nums 2 = " + nums);
//			}else {
			System.out.println("nums 3 = " + nums);
				this.getServletContext().setAttribute("nums",
						(Integer.parseInt(nums)+1)+"");
				
				
//			}
			
			
			
			
//			request.getRequestDispatcher("/Ok").forward(request, response); //
			response.sendRedirect("/ServletContextTwo/Ok");//防止刷新产生的访问次数统计
			
			
		}else {
			out.println("登录失败");
			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

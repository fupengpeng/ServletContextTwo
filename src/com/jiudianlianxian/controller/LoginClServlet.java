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
 * Description: ��¼����
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: ServletContextTwo
 * @author fupengpeng
 * @date 2017��7��29�� ����9:08:35
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
		
		//��������
		String password = request.getParameter("password");
		
		if ("111".equals(password)) {
			out.println("��¼�ɹ�");
			
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
			response.sendRedirect("/ServletContextTwo/Ok");//��ֹˢ�²����ķ��ʴ���ͳ��
			
			
		}else {
			out.println("��¼ʧ��");
			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.jiudianlianxian.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Title: Ok
 * Description: ��¼�ɹ�
 * Company: �����ŵ�������Ϣ�������޹�˾
 * ProjectName: ServletContextTwo
 * @author fupengpeng
 * @date 2017��7��29�� ����9:11:29
 *
 */
@WebServlet("/Ok")
public class Ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ok() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>��¼�ɹ�����ҳ��</h1>");
		String nums = this.getServletContext().getAttribute("nums").toString();
		out.println("�ù���ҳ�汻������"+nums+"��");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

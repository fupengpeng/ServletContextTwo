package com.jiudianlianxian.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * Title: InitServlet 
 * Description: ��ʼ�� ���ʴ������ӱ����ļ��л�ȡ�ϴη������ر�ʱ���ʴ���վ�Ĵ�������ֵ����μ�¼��ServletContext��
 * Company: �����ŵ�������Ϣ�������޹�˾ 
 * ProjectName:ServletContextTwo
 * @author fupengpeng
 * @date 2017��7��29�� ����9:41:17
 *
 */
// @WebServlet("/InitServlet")
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InitServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		// ��record��ȡ�����
		// 1.�õ��ļ�������·��
		String filePath = this.getServletContext().getRealPath("record.text");
		System.out.println("filePath = " + filePath);
		try {
			// 2.���ļ�
			FileReader fileReader = new FileReader(filePath); // Ϊ�˶�ȡ���㣬ת��BufferedReader
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String nums = bufferedReader.readLine();
			System.out.println("nums 4 = " + nums);
			// ��nums��ӵ�ServletContext
			this.getServletContext().setAttribute("nums", nums);

			bufferedReader.close();
			fileReader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("init����������");
	}

	public void destroy() {

		// �ر�ʱ����ServletContext��ֵ���浽�ļ���
		// 1.�õ��ļ�������·��
		String filePath = this.getServletContext().getRealPath("record.text");
		System.out.println("filePath  destroy = " + filePath);
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			// 2.���ļ�
		    fileWriter = new FileWriter(filePath); // Ϊ�˶�ȡ���㣬ת��BufferedReader
			bufferedWriter = new BufferedWriter(fileWriter);
			// ��ServletContext�л�ȡnums
			String nums = (String) this.getServletContext().getAttribute("nums");
			//����д���ļ�
			System.out.println("nums 5 = " + nums);
			bufferedWriter.write(nums);
			
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
				
				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("destroy����������");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

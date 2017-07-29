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
 * Description: 初始化 访问次数（从保存文件中获取上次服务器关闭时访问此网站的次数并赋值给这次记录的ServletContext）
 * Company: 济宁九点连线信息技术有限公司 
 * ProjectName:ServletContextTwo
 * @author fupengpeng
 * @date 2017年7月29日 上午9:41:17
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
		// 从record读取浏览量
		// 1.得到文件的真是路径
		String filePath = this.getServletContext().getRealPath("record.text");
		System.out.println("filePath = " + filePath);
		try {
			// 2.打开文件
			FileReader fileReader = new FileReader(filePath); // 为了读取方便，转成BufferedReader
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String nums = bufferedReader.readLine();
			System.out.println("nums 4 = " + nums);
			// 把nums添加到ServletContext
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

		System.out.println("init方法被调用");
	}

	public void destroy() {

		// 关闭时，把ServletContext的值保存到文件中
		// 1.得到文件的真是路径
		String filePath = this.getServletContext().getRealPath("record.text");
		System.out.println("filePath  destroy = " + filePath);
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			// 2.打开文件
		    fileWriter = new FileWriter(filePath); // 为了读取方便，转成BufferedReader
			bufferedWriter = new BufferedWriter(fileWriter);
			// 从ServletContext中获取nums
			String nums = (String) this.getServletContext().getAttribute("nums");
			//重新写回文件
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

		System.out.println("destroy方法被调用");
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

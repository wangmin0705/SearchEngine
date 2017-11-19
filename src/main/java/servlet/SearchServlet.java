package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lucenepkg.Indexer;
import lucenepkg.Searcher;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//���ñ����ʽ��dopost��������ҲҪд����ֹpost��ʽ�ύ
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String searcherwords;
		searcherwords = request.getParameter("search");
		System.out.println(searcherwords);
		
		String results = "";
		if(searcherwords == ""){
			results = "Please input some keywords!";
		}
		
		
		/*Indexer index = new Indexer();
		index.createIndex();*/
		else{
			Searcher sea = new Searcher();
			results  += sea.indexSearch(searcherwords);
		}
		
		
		System.out.println(results);
		request.getSession().setAttribute("results", results);
		
		response.setHeader("refresh", "0;URL=index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("content-type","text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		doGet(request, response);
	}

}

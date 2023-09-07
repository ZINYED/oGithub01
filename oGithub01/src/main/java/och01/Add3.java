package och01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add3
 */
@WebServlet("/Add3")
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // request = 입력한 객체(브라우저에서 서버로 요청할 때)  /  response = 웹 화면에 뿌려줄 결과(서버로부터 브라우저에 응답할 때)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Upload 내용 수정");
		
		// Parameter 받기 (text로 입력된 값을 int로 변환)
		int num = Integer.parseInt(request.getParameter("num"));
		String loc = request.getParameter("loc");
		System.out.println("num -> " + num);
		System.out.println("loc -> " + loc);
		// 목표 : 1부터 누적 값 전달
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.println("sum -> " + sum);
		
		// Encoding 적용 (get 방식은 request encoding 생략 가능) 
		// request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 공식 --> 사용자 Browser에 보여주는 객체
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.printf("<h1>1부터 %d까지 합계</h1>", num);
		out.printf("<h4>LOC --> %s</h4>", loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost 여기왔네");
		// 시기 --> request Parameter 받기 전 Encoding 적용
		request.setCharacterEncoding("utf-8");
		// Parameter 받기 (text로 입력된 값을 int로 변환)
		int num = Integer.parseInt(request.getParameter("num"));
		String loc = request.getParameter("loc");
		System.out.println("num -> " + num);
		System.out.println("loc -> " + loc);
		// 목표 : 1부터 누적 값 전달
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.println("sum -> " + sum);
		
		// Encoding 적용
		response.setContentType("text/html;charset=utf-8");
		
		// 공식 --> 사용자 Browser에 보여주는 객체
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.printf("<h1>1부터 %d까지 Post 합계</h1>", num);
		out.printf("<h4>LOC --> %s</h4>", loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
	}

}

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Nana extends HttpServlet
{
    public void service(HttpServletRequest request,
                        HttpServletResponse response)
                        throws IOException, ServletException
    {
        System.out.println("Hello Servlet");


        // response
        // 클라이언트에게 보내기 위한 통로 생성
        OutputStream os = response.getOutputStream();

        // byte형식이 아닌 문자열 형식으로 사용
        PrintStream out = new PrintStream(os, true);
        out.println("Hello Servlet!!!");
    }
}
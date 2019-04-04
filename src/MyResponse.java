import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Conbing
 * @date 2019/4/3
 */
public class MyResponse {


    private OutputStream outputStream;


    public MyResponse(OutputStream outputStream) throws Exception{
        this.outputStream = outputStream;
    }

    public void write(String content) throws Exception{
        StringBuffer httpRespone = new StringBuffer();
        httpRespone.append("HTTP/1.1 200 OK \n")
                .append("Content-Type: text/html\n")
                .append("\r\n")
                .append("<html><body>")
                .append(content)
                .append("</html></body>");
        outputStream.write(httpRespone.toString().getBytes());
        outputStream.close();
    }

}

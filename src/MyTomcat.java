import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Conbing
 * @date 2019/4/3
 */
public class MyTomcat {

    private int port = 8080;

    private Map<String,String> urlServletMap = new HashMap<String,String>();

    public void init(int port){
        this.port = port;
    }

    public void start(){
        initServletMapping();

        ServerSocket serverSocket = null;
        System.out.println("MyTomcat is starting");
        try {
            serverSocket = new ServerSocket(port);
            while (true){
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                dispatch(new MyRequest(inputStream),new MyResponse(outputStream));
                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initServletMapping(){
        for (ServletMapping servletMapping : ServletMappingConfig.servletMappingList) {
            urlServletMap.put(servletMapping.getUrl(),servletMapping.getClazz());
        }
    }

    private void dispatch(MyRequest myRequest,MyResponse myResponse){
        String clazz = urlServletMap.get(myRequest.getUrl());
        try {
            Class<MyServlet> myServletClass = (Class<MyServlet>)Class.forName(clazz);
            MyServlet myServlet = myServletClass.newInstance();
            myServlet.service(myRequest,myResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        MyTomcat  myTomcat =  new MyTomcat();
        myTomcat.start();
    }

}

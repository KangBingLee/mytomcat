/**
 * @author Conbing
 * @date 2019/4/3
 */
public abstract class MyServlet {

    public abstract void doGet(MyRequest myRequest,MyResponse myResponse);
    public abstract void doPost(MyRequest myRequest,MyResponse myResponse);

    public void service(MyRequest myRequest,MyResponse myResponse){

        String method = myRequest.getMethod();

        if(method.equalsIgnoreCase("GET")){
            doGet(myRequest,myResponse);
        }else if (method.equalsIgnoreCase("POST")){
            doPost(myRequest,myResponse);
        }
    }

}

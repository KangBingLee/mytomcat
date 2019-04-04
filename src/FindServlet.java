/**
 * @author Conbing
 * @date 2019/4/3
 */
public class FindServlet extends MyServlet {

    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("find servlet get");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("find servlet post");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

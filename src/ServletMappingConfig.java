import java.util.ArrayList;
import java.util.List;

/**
 * @author Conbing
 * @date 2019/4/3
 */
public class ServletMappingConfig {

    public static List<ServletMapping> servletMappingList = new ArrayList<ServletMapping>();

    static {
        servletMappingList.add(new ServletMapping("find","/find","FindServlet"));
        servletMappingList.add(new ServletMapping("hello","/hello","HelloWorldServlet"));
    }

}

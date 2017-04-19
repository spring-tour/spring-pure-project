package twindy.org.SpringTest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 描述：UrlResource
 *
 * @author twindy
 * @time 2017-04-11
 */
public class ResourceTest {

    private final static Log log = LogFactory.getLog(ResourceTest.class);
    public static void main(String[] args) {
        try {
            //Resource resource = new UrlResource("file:testFile/logo.jpg");
            Resource resource = new ClassPathResource("testFile/logo.jpg");

            System.out.println("name: " + resource.getFile().getName());
            System.out.println("size: " + resource.getFile().length() / 1024.0 + "k");
        } catch (Exception e) {
            log.error(e);
        }
    }
}

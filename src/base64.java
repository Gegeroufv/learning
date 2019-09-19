import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Base64;

public class base64 {
    public static void main(String[] args) throws Exception{
        String string = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(new File("d:/a.png")));
        System.out.println(string);
    }
}

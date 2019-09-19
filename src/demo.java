import javax.sound.midi.SoundbankResource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class demo {
    public static void main(String[] args) throws Exception{
//        String name = new String().getClass().getName();
//        try {
//            Object o = Class.forName(name).newInstance();
//            System.err.println(o.getClass().getName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        boolean b = Pattern.matches("java.time.+", "java.time.localDate");
        System.out.println(b);
        String s="2019-08-15T12:55:12";
        System.out.println(LocalDateTime.parse(s));
        System.out.println(LocalDateTime.class.getCanonicalName());
        Class<?> clazz = Class.forName(String.class.getCanonicalName()).getClass();
        System.err.println(clazz.getName());
    }
}

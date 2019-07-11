import java.io.File;
import java.util.ArrayList;

/**
 * Created by ROMAN on 23.12.2018.
 */
public class Open {

    public static void main(String args[]) {

        File folder = new File("C:/FlashCards");
        if (!folder.exists()) {
            folder.mkdir();
        }

        JaxbWorker jw = new JaxbWorker();
        String fileName = "C:/FlashCards/Users.xml";

        File fn = new File(fileName);
        if (!fn.exists()) {

            Users users = new Users();
            users.setUsers(new ArrayList<User>());

            User user = new User();
            user.setName("Admin");
            user.setPassword("Admin");

            ArrayList<String> l_s = new ArrayList<String>();
            l_s.add("en");
            l_s.add("de");
            l_s.add("it");
            l_s.add("fi");
            l_s.add("fr");

            user.setLanguages_studied(l_s);

            users.getUsers().add(user);

            jw.convertObjectToXml(users, fileName);
        }

        Authorization au = new Authorization();
        au.setVisible(true);

    }

}

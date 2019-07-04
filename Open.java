import java.io.File;

/**
 * Created by ROMAN on 23.12.2018.
 */
public class Open {

    public static void main(String args[]) {

        File folder = new File("C:/FlashCards");
        if (!folder.exists()) {
            folder.mkdir();
        }

        Authorization au = new Authorization();
        au.setVisible(true);

    }

}

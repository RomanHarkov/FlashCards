import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by ����� on 10.07.2019.
 */

public class JaxbWorker {

    // ��������������� ������ �� XML �����
    public static User fromXmlToObject(String filePath) {
        try {
            // ������� ������ JAXBContext - ����� ����� ��� JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (User) un.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ��������� ������ � XML ����
    public static void convertObjectToXml(User user, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(User.class);
            Marshaller marshaller = context.createMarshaller();
            // ������������� ���� ��� ������������ ������ XML � JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // ���������� ������� � ����
            marshaller.marshal(user, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

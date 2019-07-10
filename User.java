/**
 * Created by –оман on 09.07.2019.
 */

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// определ€ем корневой элемент
@XmlRootElement(name = "User")

// определ€ем последовательность тегов в XML
@XmlType(propOrder = {"name", "password"})

public class User {

    private String name;
    private String password;

    public User() {

    }

    public User(String name, String password) {

        this.name = name;
        this.password = password;

    }

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

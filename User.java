/**
 * Created by Роман on 09.07.2019.
 */

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    private String name;
    private String password;
    @XmlElementWrapper(name = "languages")
    @XmlElement(name = "lang")
    private List<String> languages_studied;

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<String> getLanguages_studied() {
        return languages_studied;
    }

    public void setLanguages_studied(List<String> languages_studied) {
        this.languages_studied = languages_studied;
    }
}

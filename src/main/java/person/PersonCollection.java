package person;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import java.util.*;
import java.util.function.Consumer;

public class PersonCollection extends HashSet<Person> {
    public void update(PageContext pageContext) {
        HttpSession session = pageContext.getSession();
        PersonCollection personCollection = (PersonCollection) session.getAttribute("personCollect");
        if(personCollection != null) {
            clear();
            addAll(personCollection);
        }
        Map<String, String[]> param = pageContext.getRequest().getParameterMap();
        if(!param.isEmpty()) {
            if(param.get("submit")[0].equals("deleteAll")) {
                clear();
                return;
            }
            Person person = new Person(new Name(
                    param.get("firstName")[0], param.get("lastName")[0]),
                    param.get("eyeColor")[0], param.get("hairColor")[0],
                    param.get("height")[0], param.get("weight")[0]);
            if(param.get("submit")[0].equals("add")) {
                add(person);
            } else if(param.get("submit")[0].equals("delete") || param.get("submit")[0].equals("edit")) {
                forEach(person1 -> { if(person1.getHashCode().equals(param.get("hashCode")[0])) super.remove(person1); });
            }
            if(param.get("submit")[0].equals("edit")) {
                add(person);
            }
        }
    }
}

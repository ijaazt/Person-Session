package person;

import com.sun.istack.internal.Nullable;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import java.util.*;


public class PersonCollection extends HashSet<Person> {

    private Person personCreator(ServletRequest request, long id) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Name name = new Name(firstName, lastName);
        String eyeColor = request.getParameter("eyeColor");
        String hairColor = request.getParameter("hairColor");
        //int heightFt =  Integer.getInteger(request.getParameter("heightFt"));
        //int heightInch = Integer.getInteger(request.getParameter("heightInch"));
        Size height = new Size(9, 6);
        String weight = request.getParameter("weight");
        Person person = new Person(name, eyeColor, hairColor, height, weight, id);
        System.out.println(person);
        return person;
    }

    public void update(PageContext pageContext) {

        HttpSession session = pageContext.getSession();
        ServletRequest request = pageContext.getRequest();
        @Nullable
        PersonCollection personCollection = (PersonCollection) session.getAttribute("personCollect");
        if(personCollection != null) {
            clear();
            addAll(personCollection);
        }
        if(request.getParameterMap().isEmpty()) {
            return;
        }
        switch (request.getParameter("submit")) {
            case "deleteAll":
                clear();
                break;
            case "add":
                add(personCreator(request, size()));
                break;
            case "delete":
                Person person = personCreator(request, Integer.valueOf(request.getParameter("id")));
                removeIf(person1 -> person.getId().equals(person1.getId()));
                break;
            case "edit":
                person = personCreator(request, Integer.valueOf(request.getParameter("id")));
                removeIf(person1 -> person.getId().equals(person1.getId()));
                add(person);
                break;
        }
        System.out.println(this.size());
    }
}

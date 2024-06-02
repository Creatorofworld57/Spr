package ex.springsecurity_1805.DATA;

import ex.springsecurity_1805.servisies.ServiceApp;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DATA {
    private int id;
    private ServiceApp serviceApp;
    public DATA(int id,ServiceApp serviceApp){
        this.id=id;
        this.serviceApp=serviceApp;
    }

    String NAME = serviceApp.applicationById(id).getName();
    String AUTHOR = serviceApp.applicationById(id).getAuthor();
    String Version = serviceApp.applicationById(id).getVersion();
}

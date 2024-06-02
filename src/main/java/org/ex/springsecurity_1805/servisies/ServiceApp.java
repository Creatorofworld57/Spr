package ex.springsecurity_1805.servisies;

import com.github.javafaker.Faker;
import ex.springsecurity_1805.Models.Application;
import ex.springsecurity_1805.UserRepository;
import ex.springsecurity_1805.Models.Usermain;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;


@Service
@AllArgsConstructor
public class ServiceApp {
    private List<Application> applicationList;
    private UserRepository repository;
    private PasswordEncoder passwordEncoder;
    @PostConstruct
    public void loadAppInDB(){
        Faker faker = new Faker();
        applicationList = IntStream.rangeClosed(1,100)
                .mapToObj(i->Application.builder()
                        .id(i)
                        .name(faker.app().name())
                        .author(faker.app().author())
                        .version(faker.app().version())
                        .build())
                .toList();
    }

    public List<Application> allApplications(){
        return applicationList;
    }
    public Application applicationById(int id){

        return  applicationList.stream()
        .filter(app->app.getId() == id)
               .findFirst().orElse(null);
    }
    public Application applicationByName(String name){
        return applicationList.stream()
                .filter(app->app.getName() == name)
                .findFirst().orElse(null);
    }

    public void addUser(Usermain user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);

    }


}

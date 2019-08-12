package pl.piotrpestka.bestCars.user;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    boolean addNewUser (String name, String lastName, String email, String password, String city, String street, int number){
        boolean isUserExist = userRepository.findAll().stream().anyMatch(user -> user.getEmail().equals(email));
        if (isUserExist){
            throw new RuntimeException ("this email is already in our system");
        }
        User user = new User(name,lastName, email,passwordEncoder.encode(password), city, street, number);
        User userAdded = userRepository.save(user);

        return userAdded !=null;
    }
}


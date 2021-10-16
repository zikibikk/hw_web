package services;

import forms.SignInForm;
import models.User;
import forms.UserInfo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import repositories.UsersRepository;

import javax.servlet.http.Cookie;
import java.util.UUID;

public class UsersServiceImpl implements UsersService{

    private UsersRepository usersRepository;
    //private PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public User register(UserInfo userInfo) {
        User user = User.builder()
                .firstName(userInfo.getFirstName())
                .lastName(userInfo.getLastName())
                .login(userInfo.getLogin())
                .passwordHash(userInfo.getPassword())
                .build();

        return usersRepository.save(user);
    }

    @Override
    public Cookie signIn(SignInForm signInForm) {
        User user = usersRepository.findByLogin(signInForm.getLogin());

        if (user != null) {
            if (signInForm.getPassword().equals(user.getPasswordHash())) {
                System.out.println("Вы вошли в систему");
                String cookieValue = UUID.randomUUID().toString();
                System.out.println(cookieValue);
                Cookie cookie = new Cookie("auth", cookieValue);
                cookie.setMaxAge(10 * 60 * 60);
                return cookie;
            } else {
                System.out.println("Не вошли");
            }
        }

        return null;
    }
}

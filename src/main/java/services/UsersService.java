package services;

import forms.SignInForm;
import models.User;
import forms.UserInfo;

import javax.servlet.http.Cookie;

public interface UsersService {
    User register(UserInfo userInfo);
    Cookie signIn(SignInForm signInForm);
}

package servlets;

import forms.SignInForm;
import repositories.UsersRepository;
import repositories.UsersRepositoryJdbcImpl;
import services.UsersService;
import services.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/sign_in")
public class SignInServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "123";
    private UsersService usersService;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = null;
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            UsersRepository usersRepository = new UsersRepositoryJdbcImpl(connection);
            usersService = new UsersServiceImpl(usersRepository);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            System.out.println("Unavailable");
            throw new UnavailableException("Сайт недоступен");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/sign_in.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        SignInForm signInForm = new SignInForm(login, password);
        Cookie cookie = usersService.signIn(signInForm);

        if (cookie != null) {
            resp.addCookie(cookie);
            resp.sendRedirect("/profile");
        } else {
            System.out.println("Неправильный логин");
            req.setAttribute("signInStatus", "Неправильный логин или пароль");
            req.getRequestDispatcher("jsp/sign_in.jsp").forward(req, resp);
        }
    }
}

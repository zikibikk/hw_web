package servlets;

import lombok.SneakyThrows;
import forms.UserInfo;
import repositories.UsersRepository;
import repositories.UsersRepositoryJdbcImpl;
import services.UsersService;
import services.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/sign_up")
public class RegistrationServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "123";

    private UsersService usersService;

    @SneakyThrows
    @Override
    public void init() throws ServletException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(connection);
        usersService = new UsersServiceImpl(usersRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        UserInfo userInfo = new UserInfo();
        userInfo.setLastName(req.getParameter("lastName"));
        userInfo.setFirstName(req.getParameter("firstName"));
        userInfo.setLogin(req.getParameter("login"));
        userInfo.setPassword(req.getParameter("password"));
        System.out.println(req.getParameterNames());
        req.getParameterNames();

        usersService.register(userInfo);
        req.getRequestDispatcher("/jsp/registration.jsp").forward(req, resp);
    }
}

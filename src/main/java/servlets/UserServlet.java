package servlets;

import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private List<User> users;

    @Override
    public void init() throws ServletException {
        users = new ArrayList<>();

        User user1 = User.builder()
                .id(1L)
                .firstName("Alina")
                .lastName("Nisamova")
                //.age(23)
                .build();

        User user2 = User.builder()
                .id(2L)
                .firstName("Alsu")
                .lastName("Gibadullina")
                //.age(24)
                .build();

        User user3 = User.builder()
                .id(6L)
                .firstName("Elina")
                .lastName("Malygina")
                //.age(24)
                .build();

        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*PrintWriter writer = response.getWriter();

        StringBuilder resultHTML = new StringBuilder();
        resultHTML.append("<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Users</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Users</h1>\n" +
                "<div>\n" +
                "    <table>\n" +
                "        <tr>\n" +
                "            <th>ID</th>\n" +
                "            <th>FIRST NAME</th>\n" +
                "            <th>LAST NAME</th>\n" +
                "            <th>AGE</th>\n" +
                "        </tr>\n" +
                "        <tr>\n");
        for (User user: users){
            resultHTML.append("<tr>\n");
            resultHTML.append("<td>\n").append(user.getId()).append("</td>");
            resultHTML.append("<td>\n").append(user.getFirstName()).append("</td>");
            resultHTML.append("</tr>");
        }

        resultHTML.append(
                "       </table>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");

        writer.write(resultHTML.toString());*/
        request.setAttribute("usersForJsp", users);
        request.getRequestDispatcher("/jsp/users.jsp").forward(request, response);
    }
}

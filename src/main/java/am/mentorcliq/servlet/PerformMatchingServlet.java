package am.mentorcliq.servlet;

import am.mentorcliq.pojo.MatchScore;
import am.mentorcliq.pojo.Message;
import am.mentorcliq.pojo.User;
import am.mentorcliq.service.UserCsvParser;
import am.mentorcliq.service.UserMatcher;
import am.mentorcliq.util.Constants;
import am.mentorcliq.util.CriteriaUtil;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "PerformMatchingServlet", urlPatterns = "/performmatching")
@MultipartConfig
public class PerformMatchingServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    final Part filePart = request.getPart(Constants.FILE);
    String contentType = filePart.getContentType();

    System.out.println(contentType);

    if (!Constants.TEXT_CSV.equalsIgnoreCase(contentType)) {
      Message message = new Message(Constants.INVALID_FORMAT_MSG, Constants.DANGER);
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      response.getWriter().write(new Gson().toJson(message));
    } else {
      Stack<User> usersStack = new Stack<>();
      usersStack.addAll(UserCsvParser.INSTANCE.parse(filePart.getInputStream()));
      List<MatchScore> matchScores = new UserMatcher(CriteriaUtil.getCriterias()).match(usersStack);
      System.out.println(matchScores);

      matchScores.sort(Comparator.comparing(MatchScore::getMatchScore).reversed());
      request.setAttribute(Constants.MATCH_SCORES, matchScores);
      request.getRequestDispatcher("/WEB-INF/match-result.jsp").forward(request, response);
    }
  }

  protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
      throws ServletException, IOException {
    throw new UnsupportedOperationException();
  }
}

package am.mentorcliq.service;

import am.mentorcliq.pojo.MatchScore;
import am.mentorcliq.pojo.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UserMatcher {

  List<Criteria> criterias;

  public UserMatcher(List<Criteria> criterias) {
    this.criterias = criterias;
  }


  /**
   * Iterates over stack of users and compares each of them with each of the following users. Compared user is removed
   * from the stack, operation is continued until no users are left in the stack.
   *
   * @param users
   * @return List of {@link MatchScore}
   */
  public List<MatchScore> match(Stack<User> users) {
    List<MatchScore> matchScores = new ArrayList<>();

    while (users.size() != 0) {
      User firstUser = users.pop();
      users.forEach(user -> matchScores.add(matchTwo(firstUser, user)));
    }

    return matchScores;
  }

  /**
   * Compares two users passed as parameters with matcher's criterias.
   *
   * @param firstUser
   * @param secondUser
   * @return result {@link MatchScore} after comparison
   */
  private MatchScore matchTwo(User firstUser, User secondUser) {
    MatchScore matchScore = new MatchScore();
    matchScore.setFirstUser(firstUser);
    matchScore.setSecondUser(secondUser);

    int score = 0;
    for (Criteria criteria : criterias) {
      if (criteria.match(firstUser, secondUser)) {
        score += criteria.getScore();
      }
    }

    matchScore.setMatchScore(score);
    return matchScore;
  }
}

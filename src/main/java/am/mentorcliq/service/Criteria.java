package am.mentorcliq.service;

import am.mentorcliq.pojo.User;

public class Criteria {

  private Matchable matchable;
  private int score = 0;

  public Criteria(Matchable matchable, int score) {
    this.matchable = matchable;
    this.score = score;
  }

  public boolean match(User user1, User user2) {
    return matchable.match(user1, user2);
  }

  public int getScore() {
    return score;
  }
}

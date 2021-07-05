package am.mentorcliq.pojo;

public class MatchScore {

  private User firstUser;
  private User secondUser;
  int matchScore;

  public User getFirstUser() {
    return firstUser;
  }

  public void setFirstUser(User firstUser) {
    this.firstUser = firstUser;
  }

  public User getSecondUser() {
    return secondUser;
  }

  public void setSecondUser(User secondUser) {
    this.secondUser = secondUser;
  }

  public int getMatchScore() {
    return matchScore;
  }

  public void setMatchScore(int matchScore) {
    this.matchScore = matchScore;
  }
}

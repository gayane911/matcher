package am.mentorcliq.util;

import am.mentorcliq.service.Criteria;
import am.mentorcliq.service.Matchable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class CriteriaUtil {

  /**
   * Creates and returns list of {@link Criteria} based on current requirements.
   *
   * @return List of {@link Criteria}
   */
  public static List<Criteria> getCriterias() {

    List<Criteria> criterias = new ArrayList<>();

    criterias.add(createCriteria((u1, u2) -> Math.abs(u1.getAge() - u2.getAge()) <= 5, 30));
    criterias.add(createCriteria(
        (u1, u2) -> !StringUtils.isEmpty(u1.getDivision()) && u1.getDivision().equalsIgnoreCase(u2.getDivision()), 30));
    criterias.add(createCriteria(
        (u1, u2) -> !StringUtils.isEmpty(u1.getTimezone()) && u1.getTimezone().equalsIgnoreCase(u2.getTimezone()), 40));

    return criterias;
  }

  private static Criteria createCriteria(Matchable matchable, int score) {
    Criteria c = new Criteria(matchable, score);
    return c;
  }

}

package am.mentorcliq.service;

import am.mentorcliq.pojo.User;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public enum UserCsvParser {

  INSTANCE;

  /**
   * Receives .csv file as input stream and performs parsing operation starting from second line.
   * Returns list of {@link User}
   *
   * @param stream
   * @return List of {@link User}
   */
  public List<User> parse(InputStream stream) {
    List<User> beans = new CsvToBeanBuilder<User>(new InputStreamReader(stream))
        .withType(User.class)
        .withSkipLines(1)
        .build()
        .parse();

    beans.forEach(System.out::println);
    return beans;
  }

}

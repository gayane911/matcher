package am.mentorcliq.service;

import am.mentorcliq.pojo.User;

public interface Matchable {

    boolean match(User user1, User user2);

}

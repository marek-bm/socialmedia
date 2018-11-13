package pl.coderslab.socialmedia.service;

import pl.coderslab.socialmedia.model.Tweet;
import pl.coderslab.socialmedia.model.User;

import java.util.List;

public interface TweetService {

    List<Tweet> findAllByAuthor(User author);

    Tweet save(Tweet tweet);

    List<Tweet> findAllByAuthorIn(List<User> authors);

    Tweet findById(long id);
}

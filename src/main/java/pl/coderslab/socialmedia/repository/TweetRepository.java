package pl.coderslab.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.socialmedia.model.Tweet;
import pl.coderslab.socialmedia.model.User;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

    List<Tweet> findAllByAuthor(User author);

    List<Tweet> findAllByAuthorIn(List<User> authors);

    Tweet findById(long id);
}

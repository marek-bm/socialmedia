package pl.coderslab.socialmedia.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.socialmedia.model.Tweet;
import pl.coderslab.socialmedia.model.User;
import pl.coderslab.socialmedia.repository.TweetRepository;
import pl.coderslab.socialmedia.service.TweetService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TweetServiceImpl implements TweetService {

    @Autowired
    TweetRepository tweetRepository;

    @Override
    public List<Tweet> findAllByAuthor(User author) {

        try {

            List<Tweet> tweets=tweetRepository.findAllByAuthor(author);
            return tweets;

        } catch (NullPointerException e) {

            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public Tweet save(Tweet tweet) {

        return tweetRepository.saveAndFlush(tweet);

    }

    @Override
    public List<Tweet> findAllByAuthorIn(List<User> authors) {
        try {

            List<Tweet> tweets=tweetRepository.findAllByAuthorIn(authors);
            return tweets;

        } catch (NullPointerException e) {

            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    @Override
    public Tweet findById(long tweetId) {
        try {
            return tweetRepository.findById(tweetId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}

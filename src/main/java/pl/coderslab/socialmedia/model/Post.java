package pl.coderslab.socialmedia.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private long numberOfLikes;

    @Getter @Setter
    @OneToMany (mappedBy = "post")
    private List<Comment> comments;

    @Getter @Setter
    @Size(max=1000)
    private String text;

    @Getter @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Getter @Setter
    private  User author;

    @Getter @Setter
    private Group group;

}

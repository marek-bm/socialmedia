package pl.coderslab.socialmedia.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private long numberOfLikes;

    @Getter @Setter
    @OneToMany
    private List<Comment> comments;

    @Getter @Setter
    @Size(max=1000)
    private String text;

    @Getter @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Getter @Setter
    @ManyToOne
    private  User author;

    @Getter @Setter
    @ManyToOne
    private Group group;

    public Tweet() {
        this.dateCreated=new Date();
        this.comments=new ArrayList<>();
        this.numberOfLikes=0;
    }

}

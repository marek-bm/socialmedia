package pl.coderslab.socialmedia.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private long numberOfLikes;

    @Getter @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Getter @Setter
    private String text;

    @ManyToOne (cascade = CascadeType.MERGE)
    @Getter @Setter
    User author;

    @ManyToOne (cascade = CascadeType.MERGE)
    private Post post;


}

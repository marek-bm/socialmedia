package pl.coderslab.socialmedia.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="groups")
public class Group {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    @ManyToMany
    private List<User> members;

    @Getter @Setter
    private String description;

    @Getter @Setter
    @OneToMany
    private List<Tweet> tweets;

}

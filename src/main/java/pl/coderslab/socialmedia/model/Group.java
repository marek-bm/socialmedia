package pl.coderslab.socialmedia.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class Group {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    @OneToMany
    private List<User> members;

    @Getter @Setter
    private String description;

    @Getter @Setter
    @OneToMany
    private List<Post> posts;

}

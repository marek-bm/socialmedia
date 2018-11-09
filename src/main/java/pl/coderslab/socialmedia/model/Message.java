package pl.coderslab.socialmedia.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String text;

    @Getter @Setter
    private User sender;

    @Getter @Setter
    private User reciever;

    @Getter @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Getter @Setter
    private boolean readStatus;


    public Message() {
        this.readStatus=false; //by default is unread
    }
}

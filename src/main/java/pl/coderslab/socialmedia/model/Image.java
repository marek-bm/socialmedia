package pl.coderslab.socialmedia.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name="images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String type;

    @Getter @Setter
    private long size;


    @Lob
    private byte[] data;

    public Image(String name, String type, byte[] data) {
        this.name = name;
        this.type=type;
        this.data = data;
    }
}

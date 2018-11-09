package pl.coderslab.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.socialmedia.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

    Image findById(long id);

}

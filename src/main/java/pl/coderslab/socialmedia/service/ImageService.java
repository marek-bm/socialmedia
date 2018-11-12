package pl.coderslab.socialmedia.service;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.socialmedia.model.Image;

import java.awt.print.Pageable;
import java.io.File;
import java.util.List;

public interface ImageService {

    Image save(MultipartFile file);

    Image loadById(long id);

    void deleteImage(long id);

    List<String> getPathsToAvatars();

    Page<String> getPagedPathsToAvatars();


}

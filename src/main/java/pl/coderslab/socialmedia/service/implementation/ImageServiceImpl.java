package pl.coderslab.socialmedia.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.socialmedia.model.Image;
import pl.coderslab.socialmedia.repository.ImageRepository;
import pl.coderslab.socialmedia.service.ImageService;

import java.awt.print.Pageable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;

    @Override
    public Image save(MultipartFile file) {


        
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try{
            Image img=new Image(fileName, file.getContentType(), file.getBytes());
            imageRepository.save(img);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Image loadById(long id) {

        try{
            return imageRepository.findById(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void deleteImage(long id) {

        Image img=imageRepository.findById(id);
        imageRepository.delete(img) ;
    }

    @Override
    public List<String> getPathsToAvatars() {
        String directoryPath = "./src/main/resources/static/avatars";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        List<String> filesPaths=new ArrayList<>();

        for(File f:files){
            String name=f.getName();
            final String PATH ="avatars/";
            String resulting=PATH+name;
            filesPaths.add(resulting);
        }
        return filesPaths;
    }

    @Override
    public Page<String> getPagedPathsToAvatars() {
        String directoryPath = "./src/main/resources/static/avatars";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        List<String> filesPaths=new ArrayList<>();

        for(File f:files){
            String name=f.getName();
            final String PATH ="avatars/";
            String resulting=PATH+name;
            filesPaths.add(resulting);
        }

        Page<String> pagedPaths=new PageImpl<>(filesPaths);
        return pagedPaths;
    }


}

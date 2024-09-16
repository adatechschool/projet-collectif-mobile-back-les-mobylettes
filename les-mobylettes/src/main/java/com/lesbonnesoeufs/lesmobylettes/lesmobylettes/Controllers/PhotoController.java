package com.lesbonnesoeufs.lesmobylettes.lesmobylettes.Controllers;

import com.lesbonnesoeufs.lesmobylettes.lesmobylettes.Exceptions.ResourcesNotFoundException;
import com.lesbonnesoeufs.lesmobylettes.lesmobylettes.Models.Photo;
import com.lesbonnesoeufs.lesmobylettes.lesmobylettes.Repository.PhotoRepo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1")

public class PhotoController {
    private final PhotoRepo photoRepo;

    public PhotoController(PhotoRepo photoRepo){
        this.photoRepo = photoRepo;
    }

    @GetMapping("/photos")
    public List<Photo> getAllPhotos(){
        return photoRepo.findAll();
    }

    @GetMapping("/photos/{id}")
    public Photo getPhotoByID(@PathVariable(value = "id") Long PhotoID) throws ResourcesNotFoundException {
        return photoRepo.findById(PhotoID)
                .orElseThrow(() ->new ResourcesNotFoundException("Photo avec ID : "+PhotoID +" est inexistant"));
    }

    @DeleteMapping("/photos/{id}")
    public void deletePhotoByID(@PathVariable(value = "id") Long PhotoID)throws ResourcesNotFoundException{
        Photo picture = photoRepo.findById(PhotoID)
                .orElseThrow(() ->new ResourcesNotFoundException("Photo avec ID : " +PhotoID + " est Inexistant"));
    }

    @PutMapping("/photos/{id}")
    public Photo UpdatePhoto(@PathVariable(value = "id") Long PhotoID,
                             @Validated @RequestBody Photo photoDetails) throws ResourcesNotFoundException{
        Photo picture = photoRepo.findById(PhotoID)
                .orElseThrow(() ->new ResourcesNotFoundException("Photo avec ID : " +PhotoID + " est Inexistant"));
        picture.setTitle(photoDetails.getTitle());
        picture.setUrl(photoDetails.getUrl());
        picture.setDateAdded(photoDetails.getDateAdded());

        return photoRepo.save(picture);

    }

}


package com.lesbonnesoeufs.lesmobylettes.lesmobylettes.Controllers;


import com.lesbonnesoeufs.lesmobylettes.lesmobylettes.Exceptions.ResourcesNotFoundException;
import com.lesbonnesoeufs.lesmobylettes.lesmobylettes.Models.Product;
import com.lesbonnesoeufs.lesmobylettes.lesmobylettes.Repository.ProductRepo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ProductController {
    private final ProductRepo productRepo;


    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProductByID(@PathVariable(value = "id") Long ProdID) throws ResourcesNotFoundException {
        return productRepo.findById(ProdID)
                .orElseThrow(() ->new ResourcesNotFoundException("Spot avec ID : "+ProdID +" est inexistant"));
    }
    @DeleteMapping("/products{id}")
        public void deleteProduct(@PathVariable(value = "id")Long ProdID) throws ResourcesNotFoundException{
            Product prod = productRepo.findById(ProdID)
                 .orElseThrow(() ->new ResourcesNotFoundException("Spot avec ID : "+ProdID +" est inexistant"));

        productRepo.delete(prod);
    }
    @PutMapping("/products{id}")
    public Product updateProduct(@PathVariable(value = "id") Long ProdID,
                                 @Validated @RequestBody Product proDetails)throws ResourcesNotFoundException{
        Product prod = productRepo.findById(ProdID)
                .orElseThrow(()->new ResourcesNotFoundException("Spot avec ID : "+ProdID +" est inexistant"));
        prod.setSurfBreak(proDetails.getSurfBreak());
        prod.setDifficultyLevel(proDetails.getDifficultyLevel());
        prod.setDestination(proDetails.getDestination() );
        prod.setGeocode(proDetails.getGeocode());
        prod.setPeakSurfSeasonBegins(proDetails.getPeakSurfSeasonBegins());
        prod.setPeakSurfSeasonEnds(proDetails.getPeakSurfSeasonEnds());
        prod.setDestinationStateCountry(proDetails.getDestinationStateCountry());
        prod.setAdress(proDetails.getAdress());


        return productRepo.save(prod);
    }
    @PostMapping("/products")
    public Product creatProd(@Validated @RequestBody Product prod){
        return productRepo.save(prod);
    }

}

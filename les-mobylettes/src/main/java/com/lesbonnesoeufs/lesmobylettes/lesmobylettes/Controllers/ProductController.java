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
    public List<Product> getAllProducts() {
        System.out.println("coucou");
        return productRepo.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProductByID(@PathVariable(value = "id") Long prodID) throws ResourcesNotFoundException {
        return productRepo.findById(prodID)
                .orElseThrow(() -> new ResourcesNotFoundException("Spot avec ID : " + prodID + " est inexistant"));
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable(value = "id") Long prodID) throws ResourcesNotFoundException {
        Product prod = productRepo.findById(prodID)
                .orElseThrow(() -> new ResourcesNotFoundException("Spot avec ID : " + prodID + " est inexistant"));
        productRepo.delete(prod);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable(value = "id") Long prodID,
                                 @Validated @RequestBody Product prodDetails) throws ResourcesNotFoundException {
        Product prod = productRepo.findById(prodID)
                .orElseThrow(() -> new ResourcesNotFoundException("Spot avec ID : " + prodID + " est inexistant"));
        prod.setSurfBreak(prodDetails.getSurfBreak());
        prod.setDifficultyLevel(prodDetails.getDifficultyLevel());
        prod.setDestination(prodDetails.getDestination());
        prod.setGeocode(prodDetails.getGeocode());
        prod.setPeakSurfSeasonBegins(prodDetails.getPeakSurfSeasonBegins());
        prod.setPeakSurfSeasonEnds(prodDetails.getPeakSurfSeasonEnds());
        prod.setDestinationStateCountry(prodDetails.getDestinationStateCountry());
        prod.setAddress(prodDetails.getAddress());
        prod.setPhotoUrl(prodDetails.getPhotoUrl());

        return productRepo.save(prod);
    }

    @PostMapping("/products")
    public Product createProduct(@Validated @RequestBody Product prod) {
        return productRepo.save(prod);
    }
}

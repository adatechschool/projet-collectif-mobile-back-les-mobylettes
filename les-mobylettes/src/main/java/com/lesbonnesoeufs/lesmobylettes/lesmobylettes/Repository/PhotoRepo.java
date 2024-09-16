package com.lesbonnesoeufs.lesmobylettes.lesmobylettes.Repository;

import com.lesbonnesoeufs.lesmobylettes.lesmobylettes.Models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PhotoRepo extends JpaRepository<Photo, Long> {
}

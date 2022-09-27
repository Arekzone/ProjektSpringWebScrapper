package com.scraper.first.Repository;

import com.scraper.first.Model.Kompetencje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KompetencjeRepozytorium extends JpaRepository<Kompetencje, Long> {


}

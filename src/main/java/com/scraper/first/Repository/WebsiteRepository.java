package com.scraper.first.Repository;
import com.scraper.first.Model.Website;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface WebsiteRepository extends JpaRepository<Website, Long> {

    @Query("SELECT w FROM Website w WHERE w.url = :title")
    List<Website> findAllByUrl(@Param("title") String title);


}
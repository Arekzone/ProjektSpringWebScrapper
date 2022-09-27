package com.scraper.first.Controller;

import com.scraper.first.Model.Website;
import com.scraper.first.service.WebsiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequiredArgsConstructor
@EnableJpaRepositories
public class WebsitesController {

    private List<String> websites;
    private final WebsiteService websiteService;


    @GetMapping("/websites")
    public List<Website> getWebsites(){
        return websiteService.getWebsites();

    }

    @Transactional
    @PostMapping("/posts")
    public Website addWebsite(@RequestBody Website website){
        return websiteService.addWebsite(website);
    }

    @GetMapping("/scraping")
    public List<String> webscraping(){
        return websiteService.webscraping();

    }

}

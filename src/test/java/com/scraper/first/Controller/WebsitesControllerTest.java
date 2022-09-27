package com.scraper.first.Controller;

import com.scraper.first.Model.Website;
import com.scraper.first.service.WebsiteService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class WebsitesControllerTest {

    @Autowired
    private WebsiteService websiteService;
    @Test
    void getWebsites() {
        List<Website> getWebsites = websiteService.getWebsites();
        assertEquals(1, getWebsites.size());
    }
}
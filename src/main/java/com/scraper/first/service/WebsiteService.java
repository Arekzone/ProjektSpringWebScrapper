package com.scraper.first.service;

import com.scraper.first.Model.Kompetencje;
import com.scraper.first.Model.Website;
import com.scraper.first.Repository.KompetencjeRepozytorium;
import com.scraper.first.Repository.WebsiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebsiteService {

    private List<Website> websites = new ArrayList<>();
    private List<String> asdsad = new ArrayList<>();

    private List<Kompetencje> kompetencje = new ArrayList<>();
    @Autowired
    private WebsiteRepository websitesRepository;
    @Autowired
    private KompetencjeRepozytorium kompetencjeRepozytorium;


    public List<Website> getWebsites() {
        return websitesRepository.findAll();
    }

    public List<Website> getWebsitesByUrl(String url) {
        return websitesRepository.findAllByUrl(url);
    }

    public Website addWebsite(Website website) {
        return websitesRepository.save(website);
    }

    public List<String> webscraping() {
        String inputLine;
        List<String> allLinks = new ArrayList<>();
        for (int i = 1; i <= 1; i++) {
            String url = "https://nofluffjobs.com/pl/java?page=" + i;
            StringBuilder stringBuilder = new StringBuilder();
            try {
                URL oracle = new URL(url);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(oracle.openStream()));
                while ((inputLine = in.readLine()) != null) {
                    stringBuilder.append(inputLine);
                    stringBuilder.append(System.lineSeparator());

                }
                in.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            String content = stringBuilder.toString();
            for (int j = 0; j < content.length(); j++) {
                j = content.indexOf("/pl/job/", j);
                if (j < 0) break;
                String substring = content.substring(j);
                String jobUrl = substring.split("\"")[0];
                String finalUrl = "https://nofluffjobs.com" + jobUrl;
                allLinks.add(finalUrl);

            }
            /* add allLinks to Object Website */
            for (String link : allLinks) {
                Website website = new Website();
                website.setUrl(link);
                website.setPageNumber(i);
                websitesRepository.save(website);
            }

        }
        System.err.println(wymaganiaScraping(allLinks));
        return allLinks;
    }

    public List<String> wymaganiaScraping(List<String> listaStron) {
        String inputLine2;
        for (String urls : listaStron) {
            String url = urls;
            String inputLine;
            StringBuilder stringBuilder = new StringBuilder();
            try {
                URL oracle = new URL(url);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(oracle.openStream()));
                while ((inputLine = in.readLine()) != null) {
                    stringBuilder.append(inputLine);
                    stringBuilder.append(System.lineSeparator());

                }
                in.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            String content = stringBuilder.toString();
            for (int j = 0; j < content.length(); j++) {
                j = content.indexOf("btn btn-outline-success btn-sm no-cursor text-truncate\">", j);
                if (j < 0) break;
                String substring = content.substring(j + 56);
                String jobUrl = substring.split("<")[0];
                String finalUrl = jobUrl;
                asdsad.add(finalUrl);

            }
            asdsad.add("Java");
            /* add asdsad to Object Kompetencje */
            for (String link : asdsad) {
                Kompetencje kompetencje = new Kompetencje();
                kompetencje.setNazwa(link);
                kompetencjeRepozytorium.save(kompetencje);
            }
        }
        return asdsad;
    }

    public void setOfRules(StringBuilder stringBuilder) {
        if (stringBuilder.toString().contains("Java")) {
            asdsad.add("Java");
        }
        if (stringBuilder.toString().contains("Spring")) {
            asdsad.add("Spring");
        }
        if (stringBuilder.toString().contains("English")) {
            asdsad.add("English");
        }
        if (stringBuilder.toString().contains("SQL")) {
            asdsad.add("Sql");
        }
        if (stringBuilder.toString().contains("chuuuuuj")) {
            asdsad.add("chuuuj");
        }
        if (stringBuilder.toString().contains("Team Player")) {
            asdsad.add("Team_player");
        }
        if (stringBuilder.toString().contains("Problem Solver")) {
            asdsad.add("Problem_solver");
        }
        if (stringBuilder.toString().contains("Critical thinker")) {
            asdsad.add("Critical_thinker");
        }
        if (stringBuilder.toString().contains("Hibernate")) {
            asdsad.add("Hibernate");
        }
        if (stringBuilder.toString().contains("Leadership")) {
            asdsad.add("Leadership skills");
        }
        if (stringBuilder.toString().contains("Scrum")) {
            asdsad.add("Scrum");
        }
        if (stringBuilder.toString().contains("Docker")) {
        }
        if (stringBuilder.toString().contains("Git")) {
            asdsad.add("Git");
        }
        if (stringBuilder.toString().contains("Github")) {
            asdsad.add("Github");
        }
        if (stringBuilder.toString().contains("Jenkins")) {
            asdsad.add("Jenkins");
        }
        if (stringBuilder.toString().contains("Agile")) {
            asdsad.add("Agile");
        }
        if (stringBuilder.toString().contains("Devops")) {
            asdsad.add("Devops");
        }
        if (stringBuilder.toString().contains("Linux")) {
            asdsad.add("Linux");
        }
        if (stringBuilder.toString().contains("Jakarta")) {
            asdsad.add("Jakarta");
        }
        if (stringBuilder.toString().contains("Microservices")) {
            asdsad.add("Microservices");
        }
        if (stringBuilder.toString().contains("Kubernetes")) {
            asdsad.add("Kubernetes");
        }
        if (stringBuilder.toString().contains("webpack")) {
            asdsad.add("webpack");
        }
        if (stringBuilder.toString().contains("Angular")) {
            asdsad.add("Angular");
        }
        if (stringBuilder.toString().contains("React")) {
            asdsad.add("React");
        }
        if (stringBuilder.toString().contains("JavaScript")) {
            asdsad.add("JavaScript");
        }
        if (stringBuilder.toString().contains("TypeScript")) {
            asdsad.add("TypeScript");
        }
        if (stringBuilder.toString().contains("sql")) {
            asdsad.add("SQL");
        }
        if (stringBuilder.toString().contains("AWS")) {
            asdsad.add("AWS");
        }
    }
}


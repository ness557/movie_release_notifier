package com.ness.movie_release_notifier.service;

import com.ness.movie_release_notifier.model.OmdbSearchResultWrapper;
import com.ness.movie_release_notifier.model.OmdbWrapper;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FilmOmdbServiceImpl implements FilmOmdbService {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${omdbapi.url}")
    private String apiUrl;

    @Value("${omdbapi.apikey}")
    private String apikey;

    @Override
    public OmdbSearchResultWrapper search(String title) {

        Map values = new HashMap();
        values.put("apikey", apikey);
        values.put("url", apiUrl);
        values.put("title", title);

        String templateRequest = "${url}?apikey=${apikey}&s=${title}";
        StrSubstitutor sub = new StrSubstitutor(values);
        String request = sub.replace(templateRequest);

        ResponseEntity<OmdbSearchResultWrapper> response = restTemplate.exchange(
                request,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<OmdbSearchResultWrapper>(){});

        return response.getBody();
    }

    @Override
    public OmdbSearchResultWrapper search(String title, int page) {
        Map values = new HashMap();
        values.put("apikey", apikey);
        values.put("url", apiUrl);
        values.put("title", title);
        values.put("page", page);

        String templateRequest = "${url}?" +
                "apikey=${apikey}&" +
                "s=${title}&" +
                "page=${page}";
        StrSubstitutor sub = new StrSubstitutor(values);
        String request = sub.replace(templateRequest);

        ResponseEntity<OmdbSearchResultWrapper> response = restTemplate.exchange(
                request,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<OmdbSearchResultWrapper>(){});

        return response.getBody();
    }

    @Override
    public OmdbSearchResultWrapper search(String title, int year, int page) {
        Map values = new HashMap();
        values.put("apikey", apikey);
        values.put("url", apiUrl);
        values.put("title", title);
        values.put("page", page);
        values.put("year", year);

        String templateRequest = "${url}?" +
                "apikey=${apikey}&" +
                "s=${title}&" +
                "page=${page}&" +
                "y=${year}";
        StrSubstitutor sub = new StrSubstitutor(values);
        String request = sub.replace(templateRequest);

        ResponseEntity<OmdbSearchResultWrapper> response = restTemplate.exchange(
                request,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<OmdbSearchResultWrapper>(){});

        return response.getBody();
    }

    @Override
    public OmdbWrapper getInfo(String imdbId) {
        Map values = new HashMap();
        values.put("apikey", apikey);
        values.put("url", apiUrl);
        values.put("imdbId", imdbId);

        String templateRequest = "${url}?apikey=${apikey}&i=${imdbId}";
        StrSubstitutor sub = new StrSubstitutor(values);
        String request = sub.replace(templateRequest);

        ResponseEntity<OmdbWrapper> response = restTemplate.exchange(
                request,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<OmdbWrapper>(){});

        return response.getBody();
    }
}

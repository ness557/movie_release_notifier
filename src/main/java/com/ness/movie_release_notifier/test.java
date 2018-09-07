package com.ness.movie_release_notifier;

import com.ness.movie_release_notifier.model.OmdbFullWrapper;
import com.ness.movie_release_notifier.model.OmdbWrapper;
import org.springframework.web.client.RestTemplate;

public class test {
    public static void main(String[] args) {
        new test().start();
    }

    private void start() {


//        String dateStr_1="28-Sep-2016";
//        DateTimeFormatter formatter_1=DateTimeFormatter.ofPattern("dd-MMM-yyyy").withLocale(Locale.US);
//
//        LocalDate localDate_1= LocalDate.parse(dateStr_1,formatter_1);
//        System.out.println("Input String with value: "+dateStr_1);
//        System.out.println("Converted Date in default ISO format: "+localDate_1+"\n");



        RestTemplate restTemplate = new RestTemplate();
        OmdbFullWrapper omdbWrapper = restTemplate.getForObject("http://www.omdbapi.com/?apikey=b1e85577&i=tt6017942",
                OmdbFullWrapper.class);

        System.out.println(omdbWrapper);

        System.out.println();
    }
}

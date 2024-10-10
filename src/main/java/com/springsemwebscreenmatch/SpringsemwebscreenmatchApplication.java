package com.springsemwebscreenmatch;

import com.model.DataSerie;
import com.services.ConsumptionAPI;
import com.services.ConvertData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringsemwebscreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringsemwebscreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var consumptionAPI = new ConsumptionAPI();
        var json = consumptionAPI.getData("https://www.omdbapi.com/?t=gilmore+girls&apikey=3cf984d7");
        System.out.println(json);
        ConvertData converter = new ConvertData();
        DataSerie data = converter.getDataTitle(json, DataSerie.class);
        System.out.println(data);
    }
}

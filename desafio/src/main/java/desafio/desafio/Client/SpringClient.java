package desafio.desafio.Client;

import desafio.desafio.Models.Admin;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args){
        ResponseEntity<Admin> entity =  new RestTemplate().getForEntity("http://localhost:8081/admin/{id}", Admin.class, 1);
        log.info(entity);

        Admin object = new RestTemplate().getForObject("http://localhost:8081/admin/{id}", Admin.class, 1);
        log.info(object);

        Admin[] admins = new RestTemplate().getForObject("http://localhost:8081/admin/all", Admin[].class);
        log.info(admins);

        ResponseEntity<List<Admin>> exchange = new RestTemplate().exchange("http://localhost:8081/admin/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>(){});
        log.info(exchange.getBody());

    }
}

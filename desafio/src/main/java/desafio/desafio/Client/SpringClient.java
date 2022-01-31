package desafio.desafio.Client;

import desafio.desafio.Models.Admin;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args){
        ResponseEntity<Admin> entity =  new RestTemplate().getForEntity("http://localhost:8081/admin/{id}", Admin.class, 1);
        log.info(entity);

        /**
         * GetById
         */

        Admin object = new RestTemplate().getForObject("http://localhost:8081/admin/{id}", Admin.class, 1);
        log.info(object);

        /**
         * GetAll
         */

        Admin[] admins = new RestTemplate().getForObject("http://localhost:8081/admin/all", Admin[].class);
        log.info(admins);

        ResponseEntity<List<Admin>> exchange = new RestTemplate().exchange("http://localhost:8081/admin/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>(){});
        log.info(exchange.getBody());

        /***
         * Post
         */

        //Admin adminBuild = new Admin(51, true, "Pedro", "pedro@gmail.com", "123456", true);
        Admin adminBuild = new Admin(53, true, "Pedro", "pedro@gmail.com", "123456", true);
        // new RestTemplate().postForObject("http://localhost:8081/admin/", adminBuild, Admin.class);
        ResponseEntity<Admin> adminSaved = new RestTemplate().exchange("http://localhost:8081/admin",
                HttpMethod.POST,
                new HttpEntity<>(adminBuild, createJsonHeader()),
                Admin.class);
        // log.info("saved anime {}", adminBuild);

        /**
         * PUT
         */
        Admin adminPutSaved = adminSaved.getBody();
        adminPutSaved.setId(2l);
        adminPutSaved.setName("pedro");
        adminPutSaved.setPassword("5555");
        adminPutSaved.setAdmin(true);
        adminPutSaved.setActive(true);
        adminPutSaved.setEmail("pedro@gmail.com");
        log.info(adminPutSaved);

        ResponseEntity<Void> adminUpdated = new RestTemplate().exchange("http://localhost:8081/admin",
                HttpMethod.PUT,
                new HttpEntity<>(adminPutSaved, createJsonHeader()),
                Void.class);

        /**
         * DELETE
         */
        ResponseEntity<Void> adminDelete = new RestTemplate().exchange("http://localhost:8081/admin/{id}",
                HttpMethod.DELETE,
                null,
                Void.class,
                adminPutSaved.getId());


    }

    private static HttpHeaders createJsonHeader(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}

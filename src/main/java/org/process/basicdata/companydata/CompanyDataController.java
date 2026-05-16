package org.process.basicdata.companydata;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@RestController
class CompanyDataController {


    private final RestTemplate restTemplate = new RestTemplate();


    record CompanyData(String name, String nip, String firstName, String lastName, String processId) {
    }

    @PostMapping("/company-data")
    public void handleForm(
            @RequestBody CompanyData companyData) {
        log.info("Handle company-data {}", companyData);
        sendCreateCompanyDataProcess(companyData.processId());
    }



    private void sendCreateCompanyDataProcess(String processInstanceId) {

        String url = "http://localhost:8070/form-result";

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> body = Map.of(
                "processInstanceId", processInstanceId,
                "approved", "true"

        );

        HttpEntity<Map<String, String>> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<Void> response = restTemplate.postForEntity(
                url,
                request,
                Void.class
        );

    }
}

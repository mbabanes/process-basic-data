package org.process.basicdata.companydata;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
class CompanyDataProcessController {


    private final CompanyDataProcessRepository companyDataProcessRepository;

    record CreateCompanyDataProcessRequest(String processId) {
    }


    @PostMapping("company-data-process-start")
    void createProcess(@RequestBody CreateCompanyDataProcessRequest request) {
        CompanyDataProcessEntity entity = new CompanyDataProcessEntity(request.processId());
        companyDataProcessRepository.save(entity);
    }

}

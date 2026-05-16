package org.process.basicdata.companydata;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
class CompanyDataFormController {

    private final CompanyDataProcessRepository companyDataProcessRepository;


    @GetMapping("/company-data-form/{id}")
    String getCompanyDataForm(Model model, @PathVariable String id) {

        Optional<CompanyDataProcessEntity> process = companyDataProcessRepository.findById(id);
        model.addAttribute("processId", id);
        if (process.isEmpty()) {
            return "not-found";
        }

        return "company-data-form";
    }
}

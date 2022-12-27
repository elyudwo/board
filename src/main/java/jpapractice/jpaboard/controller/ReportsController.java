package jpapractice.jpaboard.controller;

import jpapractice.jpaboard.domain.Member;
import jpapractice.jpaboard.domain.Reports;
import jpapractice.jpaboard.repository.ReportsRepository;
import jpapractice.jpaboard.service.ReportsService;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReportsController {

    private final ReportsService reportsService;
    private final ReportsRepository reportsRepository;

    @GetMapping("/reports/new")
    public String createReport(Model model) {
        model.addAttribute("reportsForm", new ReportsForm());
        return "reports/createReportsForm";
    }

    @PostMapping("/reports/new")
    public String create(@Valid ReportsForm form, BindingResult result) {
        if(result.hasErrors()) {
            return "members/createMemberForm";
        }
        Reports reports = new Reports();
        reports.setContent(form.getContent());
        reports.setTitle(form.getTitle());

        reportsService.saveReports(reports);
        return "redirect:/";
    }

    @GetMapping("/reports")
    public String reports(Model model) {
        List<Reports> reportsList = new ArrayList<>(reportsRepository.findAll());
        model.addAttribute("reports",reportsList);
        return "reports/reportsList";
    }
}

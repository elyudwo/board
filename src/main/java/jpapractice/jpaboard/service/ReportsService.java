package jpapractice.jpaboard.service;

import jpapractice.jpaboard.domain.Reports;
import jpapractice.jpaboard.repository.ReportsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReportsService {

    private final ReportsRepository reportsRepository;

    @Transactional
    public void saveReports(Reports reports) { reportsRepository.save(reports); }

    public Reports findReports(Long id) { return reportsRepository.findOne(id); }


}

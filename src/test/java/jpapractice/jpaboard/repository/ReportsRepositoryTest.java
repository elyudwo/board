package jpapractice.jpaboard.repository;

import jpapractice.jpaboard.domain.Reports;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ReportsRepositoryTest {

    @Autowired ReportsRepository reportsRepository;

    @Test
    @Transactional
    public void testPrintAll() {
        Reports reports1 = new Reports();
        Reports reports2 = new Reports();
        Reports reports3 = new Reports();

        reportsRepository.save(reports1);
        reportsRepository.save(reports2);
        reportsRepository.save(reports3);

        List<Reports> reports = new ArrayList<>(reportsRepository.findAll());
        Assertions.assertThat(reports.size()).isEqualTo(3);
    }

}

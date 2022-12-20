package jpapractice.jpaboard.repository;

import jpapractice.jpaboard.domain.Reports;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class ReportsRepository {

    private final EntityManager em;

    public void save(Reports reports) { em.persist(reports); }

    public Reports findOne(Long id) { return em.find(Reports.class,id); }
}

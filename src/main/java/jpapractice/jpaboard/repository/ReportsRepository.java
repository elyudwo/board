package jpapractice.jpaboard.repository;

import jpapractice.jpaboard.domain.Reports;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReportsRepository {

    private final EntityManager em;

    public void save(Reports reports) { em.persist(reports); }

    public Reports findOne(Long id) { return em.find(Reports.class,id); }

    public List<Reports> findAll() {
        return em.createQuery("select r from Item r",Reports.class)
                .getResultList();
    }
}

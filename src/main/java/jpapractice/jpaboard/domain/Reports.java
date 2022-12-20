package jpapractice.jpaboard.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
@Getter @Setter
public class Reports {

    @Id @GeneratedValue
    @Column(name = "reports_id")
    private Long id;

    private String title;
    private String content;
}

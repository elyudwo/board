package jpapractice.jpaboard.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String memberId;
    private String memberPasswd;
    private String name;
    private String college;

    @OneToMany(mappedBy = "member")
    private List<Reports> reportsList = new ArrayList<>();

}

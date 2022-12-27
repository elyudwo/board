package jpapractice.jpaboard.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class ReportsForm {

    @NotEmpty(message = "제목은 필수 입력 사항입니다")
    private String title;

    private String content;
}

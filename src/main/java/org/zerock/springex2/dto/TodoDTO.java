package org.zerock.springex2.dto;

//JPA에서는 DTO가 필수

// VO에서 진짜 데이터를 가지고 있고
// DTO 에서는 변환된 데이터를 제공해준다.
import jdk.vm.ci.meta.Local;
import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TodoDTO {

    private Long tno;

    // 유효성 검사 @valid 어노테이션을 컨트롤러에서 받아줌
    @NotEmpty
    private String title;
    @Future
    private LocalDate dueDate;

    private boolean finished;

    @NotEmpty
    private  String writer;
}

package likelion.kmu.session.todo.entity.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTodoRequestDTO {
    @NotBlank(message = "내용이 비어있습니다.")
    @Schema(name = "content", example = "내용입니다.")
    private String content;
}

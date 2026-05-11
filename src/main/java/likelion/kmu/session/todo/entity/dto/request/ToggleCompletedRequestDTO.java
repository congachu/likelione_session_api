package likelion.kmu.session.todo.entity.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToggleCompletedRequestDTO {

    @NotNull
    @Schema(description = "is_completed", example = "할일 완료 상태")
    private boolean isCompleted;
}

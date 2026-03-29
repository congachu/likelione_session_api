package likelion.kmu.session.post.entity.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatchPostRequestDTO {

    @Schema(description = "title", example = "제목입니다.")
    private String title;

    @Schema(description = "content", example = "내용입니다.")
    private String content;
}

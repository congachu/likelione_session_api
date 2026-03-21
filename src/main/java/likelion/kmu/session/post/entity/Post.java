package likelion.kmu.session.post.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import likelion.kmu.session.common.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Post")
@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @NotBlank
    @Column(nullable = false)
    private String content;

    public void updatePost(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void patchPost(String title, String content) {
        if(title != null) this.title = title;
        if(content != null) this.content = content;
    }
}

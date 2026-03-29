package likelion.kmu.session.post.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import likelion.kmu.session.post.entity.Post;
import likelion.kmu.session.post.entity.dto.request.PatchPostRequestDTO;
import likelion.kmu.session.post.entity.dto.request.UploadPostRequestDTO;
import likelion.kmu.session.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@Tag(name = "Post", description = "게시글 API")
public class PostController {

    private final PostService postService;

    @GetMapping("")
    @Operation(summary = "게시글 전체 조회", description = "등록된 모든 게시글을 조회합니다.")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> allPosts = postService.findAllPosts();
        return ResponseEntity.ok().body(allPosts);
    }

    @GetMapping("/{id}")
    @Operation(summary = "특정 게시글 조회", description = "id와 일치하는 게시글을 조회합니다.")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.findPostById(id);
        return ResponseEntity.ok().body(post);
    }

    @PostMapping("")
    @Operation(summary = "게시글 생성", description = "게시글을 생성합니다.")
    public ResponseEntity<Post> createPost(@Valid @RequestBody UploadPostRequestDTO req) {
        return ResponseEntity.ok().body(postService.createPost(req));
    }

    @PutMapping("/{id}")
    @Operation(summary = "게시글 전체 수정", description = "id와 일치하는 게시글을 전체 수정합니다.")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @Valid @RequestBody UploadPostRequestDTO req) {
        return ResponseEntity.ok().body(postService.updatePost(req, id));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "게시글 부분 수정", description = "id와 일치하는 게시글을 부분 수정합니다.")
    public ResponseEntity<Post> patchPost(@PathVariable Long id, @Valid @RequestBody PatchPostRequestDTO req) {
        return ResponseEntity.ok().body(postService.patchPost(req, id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "게시글 삭제", description = "id와 일치하는 게시글을 삭제합니다.")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }


}

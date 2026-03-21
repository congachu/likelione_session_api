package likelion.kmu.session.post.controller;

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
public class PostController {

    private final PostService postService;

    @GetMapping("")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> allPosts = postService.findAllPosts();
        return ResponseEntity.ok().body(allPosts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.findPostById(id);
        return ResponseEntity.ok().body(post);
    }

    @PostMapping("")
    public ResponseEntity<Post> createPost(@Valid @RequestBody UploadPostRequestDTO req) {
        return ResponseEntity.ok().body(postService.createPost(req));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @Valid @RequestBody UploadPostRequestDTO req) {
        return ResponseEntity.ok().body(postService.updatePost(req, id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Post> patchPost(@PathVariable Long id, @Valid @RequestBody PatchPostRequestDTO req) {
        return ResponseEntity.ok().body(postService.patchPost(req, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }


}

package likelion.kmu.session.post.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import likelion.kmu.session.post.entity.Post;
import likelion.kmu.session.post.entity.dto.request.PatchPostRequestDTO;
import likelion.kmu.session.post.entity.dto.request.UploadPostRequestDTO;
import likelion.kmu.session.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;


    @Transactional
    public Post createPost(UploadPostRequestDTO req){
        return postRepository.save(Post.builder()
                .title(req.getTitle())
                .content(req.getContent()).build());
    }

    @Transactional
    public Post updatePost(UploadPostRequestDTO req, Long id){
        Post findPost = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));
        findPost.updatePost(req.getTitle(), req.getContent());
        return findPost;
    }

    @Transactional
    public Post patchPost(PatchPostRequestDTO req, Long id){
        Post findPost = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));
        findPost.patchPost(req.getTitle(), req.getContent());
        return findPost;

    }

    @Transactional
    public void deletePost(Long id){
        Post findPost = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));
        postRepository.delete(findPost);
    }

    public Post findPostById(Long id){
        return postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));
    }

    public List<Post> findAllPosts(){
        return postRepository.findAll();
    }
}

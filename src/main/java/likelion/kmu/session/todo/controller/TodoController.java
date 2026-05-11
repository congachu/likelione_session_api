package likelion.kmu.session.todo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import likelion.kmu.session.todo.entity.Todo;
import likelion.kmu.session.todo.entity.dto.request.CreateTodoRequestDTO;
import likelion.kmu.session.todo.entity.dto.request.ToggleCompletedRequestDTO;
import likelion.kmu.session.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
@Tag(name = "Post", description = "게시글 API")
public class TodoController {

    private final TodoService todoService;

    @GetMapping("")
    @Operation(summary = "할일 조회", description = "학번에 해당되는 할일 전체 조회")
    public ResponseEntity<List<Todo>> getAllTodos(@RequestParam Long code) {
        List<Todo> allTodos = todoService.getTodosByCode(code);
        return ResponseEntity.ok().body(allTodos);
    }

    @PostMapping("")
    @Operation(summary = "할일 생성", description = "할일을 생성합니다.")
    public ResponseEntity<Todo> createTodo(@Valid @RequestBody CreateTodoRequestDTO req,
                                           @RequestParam Long code) {
        return ResponseEntity.ok().body(todoService.createTodo(req, code));
    }

    @PostMapping("/{id}")
    @Operation(summary = "할일 완료 상태 변경", description = "아직 안 했다면 완료로, 완료했다면 아직 안 한 것으로 변경")
    public ResponseEntity<Todo> toggleCompleted(@Valid @RequestBody ToggleCompletedRequestDTO req,
                                                @PathVariable Long id){
        return ResponseEntity.ok().body(todoService.toggleCompleted(req, id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "게시글 삭제", description = "id와 일치하는 게시글을 삭제합니다.")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }


}

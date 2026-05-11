package likelion.kmu.session.todo.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import likelion.kmu.session.todo.entity.Todo;
import likelion.kmu.session.todo.entity.dto.request.CreateTodoRequestDTO;
import likelion.kmu.session.todo.entity.dto.request.ToggleCompletedRequestDTO;
import likelion.kmu.session.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;


    @Transactional
    public Todo createTodo(CreateTodoRequestDTO req, Long code) {
        return todoRepository.save(Todo.builder()
                .content(req.getContent())
                .code(code)
                .isCompleted(false).build());
    }

    public List<Todo> getTodosByCode(Long code) {
        return todoRepository.findTodosByCode(code);
    }

    @Transactional
    public void deleteTodo(Long id) {
        Todo findTodo = todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("할일을 찾을 수 없습니다."));
        todoRepository.delete(findTodo);
    }

    @Transactional
    public Todo toggleCompleted(ToggleCompletedRequestDTO req, Long id) {
        Todo oldTodo = todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("할일을 찾을 수 없습니다."));
        return todoRepository.save(Todo.builder()
                .id(oldTodo.getId())
                .content(oldTodo.getContent())
                .code(oldTodo.getCode())
                .isCompleted(req.isCompleted()).build());
    }
}

package likelion.kmu.session.todo.repository;

import likelion.kmu.session.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Long> {
    public List<Todo> findTodosByCode(Long code);
}

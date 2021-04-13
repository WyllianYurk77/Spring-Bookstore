package springcourse.bookstore.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springcourse.bookstore.dominio.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
    
}

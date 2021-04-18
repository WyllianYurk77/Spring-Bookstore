package springcourse.bookstore.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springcourse.bookstore.dominio.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    @Query("SELECT obj FROM Livro obj WHERE obj.category.id = :idCat ORDER BY title")
    List<Livro> findAllByCategory(@Param(value = "idCat") Integer idCat);
    
}

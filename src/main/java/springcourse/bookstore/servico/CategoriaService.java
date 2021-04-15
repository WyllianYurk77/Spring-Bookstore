package springcourse.bookstore.servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springcourse.bookstore.dominio.Categoria;
import springcourse.bookstore.repositorios.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoryRepository;

    public Categoria findById(Integer id) {
        Optional<Categoria> object = categoryRepository.findById(id);
        return object.orElse(null);
    }
}

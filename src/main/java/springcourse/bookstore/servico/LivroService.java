package springcourse.bookstore.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springcourse.bookstore.dominio.Livro;
import springcourse.bookstore.repositorios.LivroRepository;
import springcourse.bookstore.servico.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

    @Autowired
    private LivroRepository bookRepo;

    @Autowired
    private CategoriaService categoryServ;

    public Livro findById(Integer id) {
        Optional<Livro> object = bookRepo.findById(id);
        return object.orElseThrow(() -> new ObjectNotFoundException(
            "Object not found! ID: " + id + ", Tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAllByCategory(Integer id) {
        categoryServ.findById(id);
        return bookRepo.findAllByCategory(id);
    }
}

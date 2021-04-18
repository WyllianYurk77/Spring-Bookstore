package springcourse.bookstore.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springcourse.bookstore.dominio.Categoria;
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

    public Livro addBook(Integer id, Livro newBook) {
        newBook.setId(null);
        Categoria cat = categoryServ.findById(id);
        newBook.setCategory(cat);
        return bookRepo.save(newBook);
    }

    public Livro update(Integer id, Livro newBook) {
        Livro boo = findById(id);
        updateData(boo, newBook);
        return bookRepo.save(boo);
    }

    private void updateData(Livro boo, Livro newBook) {
        boo.setTitle(newBook.getTitle());
        boo.setAuthor(newBook.getAuthor());
        boo.setText(newBook.getText());
    }
}

package springcourse.bookstore.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import springcourse.bookstore.dominio.Livro;
import springcourse.bookstore.dtos.LivroDTO;
import springcourse.bookstore.servico.LivroService;

@CrossOrigin("*") // Permitir que o endpoint receba requisições de outras fontes (Angular, React JS)
@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @Autowired
    private LivroService bookServ;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id) {
        Livro boo = bookServ.findById(id);
        return ResponseEntity.ok().body(boo);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAllByCategory(
            @RequestParam(value = "categoria", defaultValue = "0") Integer idCat) {
        List<Livro> list01 = bookServ.findAllByCategory(idCat);
        List<LivroDTO> list02 = list01.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(list02);
    }

    @PostMapping
    public ResponseEntity<Livro> addBook(@RequestParam(value = "categoria", defaultValue = "0") Integer idCat,
            @Valid @RequestBody Livro book) {
        Livro newBook = bookServ.addBook(idCat, book);
        URI identifier = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}")
                .buildAndExpand(newBook.getId()).toUri();
        return ResponseEntity.created(identifier).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> update(@PathVariable Integer id, @Valid @RequestBody Livro book) {
        Livro newBook = bookServ.update(id, book);
        return ResponseEntity.ok().body(newBook);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Livro> simpleUpdate(@PathVariable Integer id, @Valid @RequestBody Livro book) {
        Livro newBook = bookServ.update(id, book);
        return ResponseEntity.ok().body(newBook);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        bookServ.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}

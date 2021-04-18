package springcourse.bookstore.recursos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springcourse.bookstore.dominio.Livro;
import springcourse.bookstore.dtos.LivroDTO;
import springcourse.bookstore.servico.LivroService;

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
    public ResponseEntity<List<LivroDTO>> findAllByCategory(@RequestParam(value = "categoria", defaultValue = "0") Integer idCat) {
        List<Livro> list01 = bookServ.findAllByCategory(idCat);
        List<LivroDTO> list02 = list01.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(list02);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro book) {
        Livro newBook = bookServ.update(id, book);
        return ResponseEntity.ok().body(newBook);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Livro> simpleUpdate(@PathVariable Integer id, @RequestBody Livro book) {
        Livro newBook = bookServ.update(id, book);
        return ResponseEntity.ok().body(newBook);
    }
}

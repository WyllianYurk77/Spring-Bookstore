package springcourse.bookstore.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import springcourse.bookstore.dominio.Categoria;
import springcourse.bookstore.dtos.CategoriaDTO;
import springcourse.bookstore.servico.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService catService;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
        Categoria object = catService.findById(id);
        return ResponseEntity.ok().body(object);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<Categoria> list01 = catService.findAll();
        List<CategoriaDTO> list02 = list01.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(list02);
    }

    @PostMapping
    public ResponseEntity<Categoria> createCategory(@Valid @RequestBody Categoria cat) {
        cat = catService.createCategory(cat);
        URI identifier = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cat.getId()).toUri();
        return ResponseEntity.created(identifier).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> update(@Valid @PathVariable Integer id, @RequestBody CategoriaDTO catDTO) {
        Categoria newCat = catService.update(id, catDTO);
        return ResponseEntity.ok().body(new CategoriaDTO(newCat));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        catService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}

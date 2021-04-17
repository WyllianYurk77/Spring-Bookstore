package springcourse.bookstore.recursos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

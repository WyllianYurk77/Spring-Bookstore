package springcourse.bookstore.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springcourse.bookstore.dominio.Categoria;
import springcourse.bookstore.dtos.CategoriaDTO;
import springcourse.bookstore.repositorios.CategoriaRepository;
import springcourse.bookstore.servico.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoryRepository;

    public Categoria findById(Integer id) {
        Optional<Categoria> object = categoryRepository.findById(id);
        return object.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! ID: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll() {
        return categoryRepository.findAll();
    }

    public Categoria createCategory(Categoria cat) {
        cat.setId(null);
        return categoryRepository.save(cat);
    }

    public Categoria update(Integer id, CategoriaDTO catDTO) {
        Categoria cat = findById(id);
        cat.setName(catDTO.getName());
        cat.setDescription(catDTO.getDescription());
        return categoryRepository.save(cat);
    }

    public void deleteCategory(Integer id) {
        findById(id);
        categoryRepository.deleteById(id);
    }
}

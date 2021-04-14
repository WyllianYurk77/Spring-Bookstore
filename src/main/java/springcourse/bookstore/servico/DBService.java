package springcourse.bookstore.servico;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springcourse.bookstore.dominio.Categoria;
import springcourse.bookstore.dominio.Livro;
import springcourse.bookstore.repositorios.CategoriaRepository;
import springcourse.bookstore.repositorios.LivroRepository;

@Service
public class DBService {

    @Autowired
	private CategoriaRepository categoryRepository;
	@Autowired
	private LivroRepository bookRepository;
    
    public void initiateDatabase() {
        
        Categoria cat01 = new Categoria(null, "Informática", "Livro de Informática");
        Categoria cat02 = new Categoria(null, "Ficção Científica", "Livro de Ficção Científica");
        Categoria cat03 = new Categoria(null, "Literatura", "Livro de Literatura");
        Categoria cat04 = new Categoria(null, "Romance", "Livro de Romance");

		Livro b01 = new Livro(null, "Clean Code", "Robert Martin", "Loren Ipsun", cat01);
        Livro b02 = new Livro(null, "Neuromancer", "William Gibson", "Loren Ipsun", cat02);
        Livro b03 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Loren Ipsun", cat01);
        Livro b04 = new Livro(null, "Dom Quixote", "Miguel de Cervantes", "Loren Ipsun", cat03);
        Livro b05 = new Livro(null, "All the Bright Places", "Jennifer Niven", "Loren Ipsun", cat04);
        Livro b06 = new Livro(null, "Frankenstein", "Mary Shelley", "Loren Ipsun", cat02);

		cat01.getBooks().addAll(Arrays.asList(b01, b03));
        cat02.getBooks().addAll(Arrays.asList(b02, b06));
        cat03.getBooks().addAll(Arrays.asList(b04));
        cat04.getBooks().addAll(Arrays.asList(b05));

		this.categoryRepository.saveAll(Arrays.asList(cat01, cat02, cat03, cat04));
		this.bookRepository.saveAll(Arrays.asList(b01, b02, b03, b04, b05, b06));
    }
}

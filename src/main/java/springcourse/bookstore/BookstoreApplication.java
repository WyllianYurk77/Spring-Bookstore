package springcourse.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springcourse.bookstore.dominio.Categoria;
import springcourse.bookstore.dominio.Livro;
import springcourse.bookstore.repositorios.CategoriaRepository;
import springcourse.bookstore.repositorios.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoryRepository;
	@Autowired
	private LivroRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat01 = new Categoria(null, "Informática", "Livro de Informática");

		Livro b01 = new Livro(null, "Clean Code", "Robert Martin", "Loren Ipsun", cat01);

		cat01.getBooks().addAll(Arrays.asList(b01));

		this.categoryRepository.saveAll(Arrays.asList(cat01));
		this.bookRepository.saveAll(Arrays.asList(b01));
	}

}

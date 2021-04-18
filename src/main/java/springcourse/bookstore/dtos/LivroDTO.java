package springcourse.bookstore.dtos;

import java.io.Serializable;

import springcourse.bookstore.dominio.Livro;

public class LivroDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;

    public LivroDTO() {
        super();
    }

    public LivroDTO(Livro object) {
        super();
        this.id = object.getId();
        this.title = object.getTitle();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
}

package springcourse.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import springcourse.bookstore.dominio.Categoria;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    
    @NotEmpty(message = "Name cannot be empty")
    @Length(min = 2, max = 100, message = "Name must be at least 2 characters")
    private String name;

    @NotEmpty(message = "Description cannot be empty")
    @Length(min = 3, max = 250, message = "Description must be at least 3 characters")
    private String description;

    public CategoriaDTO() {
        super();
    }

    public CategoriaDTO(Categoria object) {
        super();
        this.id = object.getId();
        this.name = object.getName();
        this.description = object.getDescription();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

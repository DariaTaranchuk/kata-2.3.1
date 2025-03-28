package project.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotEmpty(message = "Поле не может быть пустым")
    @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]+$", message = "Имя не может содержать символы отличные от букв")
    @Column
    private String name;

    @NotEmpty(message = "Поле не может быть пустым")
    @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]+$", message = "Имя не может содержать символы отличные от букв")
    @Column
    private String surname;

    @NotNull(message = "Поле не может быть пустым")
    @Min(value = 0, message = "Возраст должен быть больше нуля")
    @Column
    private int age;

    public User(){
    }

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

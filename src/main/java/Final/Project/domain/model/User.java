package Final.Project.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String cpf;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int accessCardNumber;
    @OneToOne(cascade = CascadeType.ALL)
    private Car car;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getAccessCardNumber() {
        return accessCardNumber;
    }

    public void setAccessCardNumber(int accessCardNumber) {
        this.accessCardNumber = accessCardNumber;
    }
}

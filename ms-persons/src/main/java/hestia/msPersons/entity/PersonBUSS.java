package hestia.msPersons.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity @ToString
@Table(name = "Empressa")
public class PersonBUSS {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personBussId;

    @Column(name = "CNPJ")
    @JsonProperty("cnpj")
    private String cnpj;

    @Column(name = "endereco")
    @JsonProperty("endereco")
    private String endereco;

    @Column(name = "numero")
    @JsonProperty("numero")
    private String numero;

    @Column(name = "bairro")
    @JsonProperty("bairro")
    private String bairro;

    @Column(name = "cidade")
    @JsonProperty("cidade")
    private String cidade;

    @Column(name = "UF")
    @JsonProperty("uf")
    private String uf;

    public int getPersonBussId() {
        return personBussId;
    }

    public void setPersonBussId(int personBussId) {
        this.personBussId = personBussId;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonImg() {
        return personImg;
    }

    public void setPersonImg(String personImg) {
        this.personImg = personImg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "personImg")
    @JsonProperty("personImg")
    private String personImg;

    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @Column(name = "password")
    @JsonProperty("password")
    private String password;

    @Column(name = "active")
    private boolean active;
}
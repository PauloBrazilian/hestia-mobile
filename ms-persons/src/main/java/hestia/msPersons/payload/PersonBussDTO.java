package hestia.msPersons.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonBussDTO {

    @NotNull
    @CNPJ(message = "Cnpj is not valid")
    @Size(min = 11, max = 14,message = "The CNPJ ins't in the correct size")
    @JsonProperty("cnpj")
    private String cnpj;

    @NotNull
    @JsonProperty("endereco")
    private String endereco;

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

    @NotNull
    @Size(min = 3, max = 5,message = "O numero deve ter exatamente 5 dígitos.")
    @JsonProperty("numero")
    private String numero;

    @NotNull
    @JsonProperty("bairro")
    private String bairro;

    @NotNull
    @JsonProperty("cidade")
    private String cidade;

    @NotNull
    @Size(max = 2, message = "UF deve ter no máximo 2 caracteres.")
    @JsonProperty("uf")
    private String uf;

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("personImg")
    private String personImg;

    @NotNull
    @Email(message = "The email must be a well-formed email address")
    @JsonProperty("email")
    private String email;

    @NotNull
    @JsonProperty("password")
    private String password;

}


package org.tidesigners.logica;


public class Contato {
    
    private Long id;
    private String nome;
    private String endereco;
    private String email;
    private String fone;
    private String sexo;

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String endereco) {
        this.email = endereco;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String tel) {
        this.fone = tel;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
}


package Model;

public class Cadastro {
    // atributos
    private String nome;
    private String sobrenome;
    private String cpf;
    private String endereco;
    private String idade;
    // construtor
    public Cadastro(String nome, String sobrenome, String cpf, String endereco, String idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.idade = idade;
    }
    // getters and setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getendereco() {
        return endereco;
    }
    public void setendereco(String endereco) {
        this.endereco = endereco;
    }
    public String getidade() {
        return idade;
    }
    public void setidade(String idade) {
        this.idade = idade;
    }
}

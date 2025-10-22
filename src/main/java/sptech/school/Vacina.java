package sptech.school;

import java.time.LocalDate;

public class Vacina {
    private String codigo;
    private String nome;
    private String tipo;
    private Double preco;
    private Double eficacia;
    private LocalDate dataLancamento;

    public Vacina() {}

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getPreco() {
        return preco;
    }

    public Double getEficacia() {
        return eficacia;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setEficacia(Double eficacia) {
        this.eficacia = eficacia;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getEficaciaDescricao() {
        if (eficacia >= 90.5) {
            return "EXCELENTE";
        } else if (eficacia >= 75.5) {
            return "BOM";
        } else if (eficacia >= 50.5) {
            return "REGULAR";
        } else {
            return "RUIM";
        }
    }
}

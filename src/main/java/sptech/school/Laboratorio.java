package sptech.school;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.VacinaInvalidaException;
import school.sptech.exception.VacinaNaoEncontradaException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Laboratorio {
    private String nome;
    private List<Vacina> vacinas;

    public Laboratorio() {
        vacinas = new ArrayList<>();
    };

    public String getNome() {
        return nome;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarVacina(Vacina vacina) throws VacinaInvalidaException{
        if (vacina == null) {
            throw new VacinaInvalidaException("Vácina inválida.");
        }

        if (vacina.getCodigo() == null || vacina.getCodigo().isEmpty()) {
            throw new VacinaInvalidaException("Código inválido.");
        }

        if (vacina.getNome() == null || vacina.getNome().isEmpty()) {
            throw new VacinaInvalidaException("Nome inválido.");
        }

        if (vacina.getTipo() == null || vacina.getTipo().isEmpty()) {
            throw new VacinaInvalidaException("Tipo inválido.");
        }

        if (vacina.getPreco() == null || vacina.getPreco() <= 0.0) {
            throw new VacinaInvalidaException("Preço inválido.");
        }

        if (vacina.getEficacia() < 0.0 || vacina.getEficacia() > 5.0) {
            throw new VacinaInvalidaException("Eficácia inválida.");
        }

        if (vacina.getDataLancamento() == null || vacina.getDataLancamento().isAfter(LocalDate.now())) {
            throw new VacinaInvalidaException("Data de lançamento inválida");
        }

        vacinas.add(vacina);
    }

    public Vacina buscarVacinaPorCodigo(String codigo) throws school.sptech.exception.ArgumentoInvalidoException, school.sptech.exception.VacinaNaoEncontradaException {
        if (codigo == null || codigo.isEmpty() || codigo.isBlank()) {
            throw new ArgumentoInvalidoException("Argumento inválido.");
        }

        boolean vacinaEncontrada = false;
        Vacina vacinaPesquisada = null;

        for (Vacina v:vacinas) {
            if (v.getCodigo().equals(codigo)) {
                vacinaEncontrada = true;
                vacinaPesquisada = v;
                break;
            }
        }

        if (vacinaEncontrada == false) {
            throw new school.sptech.exception.VacinaNaoEncontradaException("Vacina não encontrada.");
        }

        return vacinaPesquisada;
    }

    public void removerVacinaPorCodigo(String codigo) throws ArgumentoInvalidoException, school.sptech.exception.VacinaNaoEncontradaException {
        if (codigo == null || codigo.isEmpty() || codigo.isBlank()) {
            throw new ArgumentoInvalidoException("Argumento inválido.");
        }

        boolean vacinaEncontrada = false;

        for (Vacina v:vacinas) {
            if (v.getCodigo().equals(codigo)) {
                vacinaEncontrada = true;
                vacinas.remove(v);
                break;
            }
        }

        if (vacinaEncontrada == false) {
            throw new school.sptech.exception.VacinaNaoEncontradaException("Vacina não encontrada.");
        }
    }

    public Vacina buscarVacinaComMelhorEficacia() throws VacinaNaoEncontradaException{
        if (vacinas.isEmpty()) {
            throw new VacinaNaoEncontradaException("Lista de vacinas vazia.");
        }

        Double melhorEficacia = 0.0;
        Vacina vacinaComMelhorEficacia = null;

        for (Vacina v:vacinas) {
            if (v.getEficacia() > melhorEficacia) {
                vacinaComMelhorEficacia = v;
                melhorEficacia = v.getEficacia();
            } else if (v.getEficacia() == melhorEficacia) {
                if (v.getDataLancamento().isBefore(vacinaComMelhorEficacia.getDataLancamento())) {
                    vacinaComMelhorEficacia = v;
                }
            }
        }

        return vacinaComMelhorEficacia;
    }

    public List<Vacina> buscarVacinaPorPeriodo(LocalDate dataInicio, LocalDate dataFim) throws ArgumentoInvalidoException{
        if (dataInicio == null || dataFim == null || dataInicio.isAfter(dataFim)) {
            throw new ArgumentoInvalidoException("Data(s) inválidas.");
        }

        ArrayList<Vacina> vacinasSelecionadas = new ArrayList<>();

        for (Vacina v:vacinas) {
            LocalDate dataLanc = v.getDataLancamento();
            if (dataLanc.isAfter(dataInicio) || dataLanc.isEqual(dataInicio) && dataLanc.isBefore(dataFim) || dataLanc.isEqual(dataFim)) {
                vacinasSelecionadas.add(v);
            }
        }

        return vacinasSelecionadas;
    }
}

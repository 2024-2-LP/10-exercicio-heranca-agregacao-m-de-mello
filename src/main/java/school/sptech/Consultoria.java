package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria() {
        this.desenvolvedores = new ArrayList<>();
    }

    public Consultoria(String nome, Integer vagas) {
        setNome(nome);
        setVagas(vagas);
        this.desenvolvedores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public void contratar(Desenvolvedor desenvolvedor) {
        if (this.desenvolvedores.size() < getVagas()) {
            this.desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (this.desenvolvedores.size() < getVagas() && desenvolvedor.isFullstack()) {
            this.desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios() {
        Double totalSalario = 0.0;

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            totalSalario += desenvolvedor.calcularSalario();
        }
        return totalSalario;
    }

    public Integer qtdDesenvolvedoresMobile() {
        return (int) this.desenvolvedores.stream()
                .filter(desenvolvedor -> desenvolvedor instanceof DesenvolvedorMobile)
                .count();
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        return this.desenvolvedores.stream()
                .filter(desenvolvedor -> desenvolvedor.calcularSalario() >= salario)
                .toList();
    }
    public Desenvolvedor buscarMenorSalario() {
        return this.desenvolvedores.stream()
                .min(Comparator.comparingDouble(Desenvolvedor::calcularSalario))
                .orElse(null);
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        return this.desenvolvedores.stream()
                .filter(desenvolvedor -> (
                        desenvolvedor instanceof DesenvolvedorWeb && (
                                ((DesenvolvedorWeb) desenvolvedor).getBackend().equalsIgnoreCase(tecnologia) ||
                                ((DesenvolvedorWeb) desenvolvedor).getFrontend().equalsIgnoreCase(tecnologia) ||
                                ((DesenvolvedorWeb) desenvolvedor).getSgbd().equalsIgnoreCase(tecnologia))) ||
                        desenvolvedor instanceof DesenvolvedorMobile && (
                                ((DesenvolvedorMobile) desenvolvedor).getPlataforma().equalsIgnoreCase(tecnologia) ||
                                ((DesenvolvedorMobile) desenvolvedor).getLinguagem().equalsIgnoreCase(tecnologia)))
                .toList();
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        List<Desenvolvedor> desenvolvedoresPorSalario = buscarPorTecnologia(tecnologia);
        Double totalSalario = 0.0;
        for (Desenvolvedor desenvolvedor : desenvolvedoresPorSalario) {
            totalSalario += desenvolvedor.calcularSalario();
        }
        return totalSalario;
    }
}

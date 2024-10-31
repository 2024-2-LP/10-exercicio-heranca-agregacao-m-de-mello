package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorMobile extends Desenvolvedor {
    private String plataforma;
    private String linguagem;
    private Integer horasPrototipacao;

    public DesenvolvedorMobile() {
    }


    public DesenvolvedorMobile(String nome, Integer qtdHoras, Double valorHora) {
        super(nome, qtdHoras, valorHora);
    }

    public DesenvolvedorMobile(String nome, Integer qtdHoras, Double valorHora, String plataforma, String linguagem, Integer horasPrototipacao) {
        super(nome, qtdHoras, valorHora);
        setPlataforma(plataforma);
        setLinguagem(linguagem);
        setHorasPrototipacao(horasPrototipacao);
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public Integer getHorasPrototipacao() {
        return horasPrototipacao;
    }

    public void setHorasPrototipacao(Integer horasPrototipacao) {
        this.horasPrototipacao = horasPrototipacao;
    }

    @Override
    public Double calcularSalario() {
        return super.calcularSalario() + (getHorasPrototipacao() * 200.00);
    }
}

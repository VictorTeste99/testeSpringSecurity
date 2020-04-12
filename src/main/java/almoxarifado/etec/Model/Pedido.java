package almoxarifado.etec.Model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "alm_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy")
    private LocalDate Dt_solicitacao;
    
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy")
    private LocalDate Dt_retirada;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy")
    private LocalDate Dt_devolucao;

    private Boolean aprovacao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_equipamento")
    private Equipamento equipamento;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_almoxarifado")
    private AlmoxarifadoSetor almoxarifadoSetor;

    public Long getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Boolean getAprovacao() {
        return this.aprovacao;
    }

    public void setAprovacao(Boolean aprovacao) {
        this.aprovacao = aprovacao;
    }

    public Equipamento getEquipamento() {
        return this.equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public AlmoxarifadoSetor getAlmoxarifadoSetor() {
        return this.almoxarifadoSetor;
    }

    public void setAlmoxarifadoSetor(AlmoxarifadoSetor almoxarifadoSetor) {
        this.almoxarifadoSetor = almoxarifadoSetor;
    }

    public LocalDate getDt_solicitacao() {
        return this.Dt_solicitacao;
    }

    public void setDt_solicitacao(LocalDate Dt_solicitacao) {
        this.Dt_solicitacao = Dt_solicitacao;
    }

    public LocalDate getDt_retirada() {
        return this.Dt_retirada;
    }

    public void setDt_retirada(LocalDate Dt_retirada) {
        this.Dt_retirada = Dt_retirada;
    }

    public LocalDate getDt_devolucao() {
        return this.Dt_devolucao;
    }

    public void setDt_devolucao(LocalDate Dt_devolucao) {
        this.Dt_devolucao = Dt_devolucao;
    }

}
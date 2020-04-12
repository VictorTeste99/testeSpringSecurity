package almoxarifado.etec.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "alm_equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    private String nome;

    @NotNull
    private String descricao;

    @NotNull
    private Boolean manutencao;

    @NotNull
    private String local;
    
    @NotNull
    private String quantidade;
    
    @NotNull
    private String foto;
    
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
    
    public Boolean getManutencao() {
        return this.manutencao;
    }

    public void setManutencao(Boolean manutencao) {
        this.manutencao = manutencao;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return this.local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public AlmoxarifadoSetor getAlmoxarifadoSetor() {
        return this.almoxarifadoSetor;
    }

    public void setAlmoxarifadoSetor(AlmoxarifadoSetor almoxarifadoSetor) {
        this.almoxarifadoSetor = almoxarifadoSetor;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
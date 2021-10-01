package br.com.mentoria.bd.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name="TB_CAMPEAO")
@GenericGenerator(
        name="SEQ_CAMPEAO",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name="sequence_name",value="SEQ_CAMPEAO"),
                @Parameter(name = "initial_value",value="2"),
                @Parameter(name = "increment_size",value="1")
        }
)
public class CampeaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="SEQ_CAMPEAO")
    @Column(name="ID_CAMPEAO")
    private Long id;
    @Column(name="DS_NOME")
    private String nome;
    @Column(name="DS_EMAIL")
    private String email;
    @Column(name="DS_COR_SABRE")
    private String corSabre;
    @Column(name="QTDA_HP")
    private Long hp;
    @Column(name="QTDA_FORCA_FISICA")
    private Long forcaFisca;
    @Column(name="QTDA_MENTAL")
    private Long mental;
    @Column(name="QTDA_PREVISAO")
    private Long previsao;
    @Column(name="QTDA_HABILIDADE_SABRE")
    private Long habilidadeComSabre;
    @Column(name="QTDA_AFINADADE_FORCA")
    private Long afinidadeForca;
    @ManyToOne(cascade={ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinTable(
            name = "TB_CAMPEAO_TIPO",
            joinColumns = @JoinColumn(name="ID_CAMPEAO",
                    referencedColumnName = "ID_CAMPEAO"),
            inverseJoinColumns = @JoinColumn(name = "ID_TIPO_CAMPEAO",
                    referencedColumnName ="ID_TIPO_CAMPEAO")
    )
    private TipoCampeao tipo;
}

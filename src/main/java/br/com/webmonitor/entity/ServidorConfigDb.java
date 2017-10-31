package br.com.webmonitor.entity;

import br.com.webmonitor.entity.Generic.GenericEntity;
import br.com.webmonitor.enumeration.EnumSgdb;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 01/09/2017.
 */
@Entity
@Table(name = "tb_servidor_config_db_scdb_id_seq", schema = "public")
@SequenceGenerator(name = "tb_servidor_config_db_scdb_id_seq", sequenceName = "public.tb_servidor_config_db_scdb_id_seq")
public class ServidorConfigDb extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_servidor_config_db_scdb_id_seq")
    @Column(name = "scdb_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serv_id")
    private Servidor servidor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "scdb_dthr_cadastro")
    private Date dthr_cadastro;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "scdb_dthr_alteracao")
    private Date dthr_alteracao;

    @Column(name = "scdb_nome_sgdb")
    private EnumSgdb nomeSgdb;

    @Column(name = "scdb_nome_db")
    private String nomeDb;

    @Column(name = "scdb_path_main")
    private String pathMain;

    @Column(name = "scdb_porta")
    private Long porta;

    @Column(name = "scdb_versao")
    private String versao;

    // Getter and Setter
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    @Override
    public Date getDthr_cadastro() {
        return dthr_cadastro;
    }

    @Override
    public void setDthr_cadastro(Date dthr_cadastro) {
        this.dthr_cadastro = dthr_cadastro;
    }

    public Date getDthr_alteracao() {
        return dthr_alteracao;
    }

    public void setDthr_alteracao(Date dthr_alteracao) {
        this.dthr_alteracao = dthr_alteracao;
    }

    public EnumSgdb getNomeSgdb() {
        return nomeSgdb;
    }

    public void setNomeSgdb(EnumSgdb nomeSgdb) {
        this.nomeSgdb = nomeSgdb;
    }

    public String getNomeDb() {
        return nomeDb;
    }

    public void setNomeDb(String nomeDb) {
        this.nomeDb = nomeDb;
    }

    public String getPathMain() {
        return pathMain;
    }

    public void setPathMain(String pathMain) {
        this.pathMain = pathMain;
    }

    public Long getPorta() {
        return porta;
    }

    public void setPorta(Long porta) {
        this.porta = porta;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }
}

package br.com.webmonitor.entity;

import br.com.webmonitor.entity.Generic.GenericEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 01/09/2017.
 */
@Entity
@Table(name = "tb_servidor_config", schema = "public")
@SequenceGenerator(name = "tb_servidor_config_serv_id_seq", sequenceName = "public.tb_servidor_config_serv_id_seq")
public class ServidorConfig extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_servidor_config_serv_id_seq")
    @Column(name = "serc_id")
    private Long id;

    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    //@JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serv_id")
    private Servidor servidor;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "serc_dthr_cadastro")
    private Date dthr_cadastro;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "serc_dthr_alteracao")
    private Date dthr_alteracao;

    @Column(name = "serc_intervalo_leitura_configuracoes", columnDefinition = "integer default 100")
    private Long intervaloLeituraConfiguracoes;

    @Column(name = "serc_intervalo_cpu", columnDefinition = "integer default 10")
    private Long intervaloCpu;

    @Column(name = "serc_intervalo_mem", columnDefinition = "integer default 10")
    private Long intervaloMemoria;

    @Column(name = "serc_intervalo_swap", columnDefinition = "integer default 10")
    private Long intervaloSwap;

    @Column(name = "serc_intervalo_db", columnDefinition = "integer default 10")
    private Long intervaloDB;

    @Column(name = "serc_host_monitoramento")
    private String hostMonitoramento;

    @Column(name = "serc_host_monitoramento_2")
    private String hostMonitoramento2;

    @Column(name = "serc_porta", columnDefinition = "integer default 8081")
    private Long porta;

    @Column(name = "serc_porta2", columnDefinition = "integer default 8080")
    private Long porta2;

    @Column(name = "serc_postgres_path_main", columnDefinition = "/etc/postgresql/9.6/main")
    private String postgresPathMain;

    @Column(name = "serc_postgres_versao", columnDefinition = "9.6")
    private String postgresVersao;

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

    public Date getDthr_cadastro() {
        return dthr_cadastro;
    }

    public void setDthr_cadastro(Date dthr_cadastro) {
        this.dthr_cadastro = dthr_cadastro;
    }

    public Date getDthr_alteracao() {
        return dthr_alteracao;
    }

    public void setDthr_alteracao(Date dthr_alteracao) {
        this.dthr_alteracao = dthr_alteracao;
    }

    public Long getIntervaloCpu() {
        return intervaloCpu;
    }

    public void setIntervaloCpu(Long intervaloCpu) {
        this.intervaloCpu = intervaloCpu;
    }

    public Long getIntervaloMemoria() {
        return intervaloMemoria;
    }

    public void setIntervaloMemoria(Long intervaloMemoria) {
        this.intervaloMemoria = intervaloMemoria;
    }

    public Long getIntervaloSwap() {
        return intervaloSwap;
    }

    public void setIntervaloSwap(Long intervaloSwap) {
        this.intervaloSwap = intervaloSwap;
    }

    public Long getIntervaloDB() {
        return intervaloDB;
    }

    public void setIntervaloDB(Long intervaloDB) {
        this.intervaloDB = intervaloDB;
    }

    public String getHostMonitoramento() {
        return hostMonitoramento;
    }

    public void setHostMonitoramento(String hostMonitoramento) {
        this.hostMonitoramento = hostMonitoramento;
    }

    public String getHostMonitoramento2() {
        return hostMonitoramento2;
    }

    public void setHostMonitoramento2(String hostMonitoramento2) {
        this.hostMonitoramento2 = hostMonitoramento2;
    }

    public Long getIntervaloLeituraConfiguracoes() {
        return intervaloLeituraConfiguracoes;
    }

    public void setIntervaloLeituraConfiguracoes(Long intervaloLeituraConfiguracoes) {
        this.intervaloLeituraConfiguracoes = intervaloLeituraConfiguracoes;
    }

    public Long getPorta() {
        return porta;
    }

    public void setPorta(Long porta) {
        this.porta = porta;
    }

    public Long getPorta2() {
        return porta2;
    }

    public void setPorta2(Long porta2) {
        this.porta2 = porta2;
    }

    public String getPostgresPathMain() {
        return postgresPathMain;
    }

    public void setPostgresPathMain(String postgresPathMain) {
        this.postgresPathMain = postgresPathMain;
    }

    public String getPostgresVersao() {
        return postgresVersao;
    }

    public void setPostgresVersao(String postgresVersao) {
        this.postgresVersao = postgresVersao;
    }
}

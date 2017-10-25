package br.com.webmonitor.entity;

import br.com.webmonitor.entity.Generic.GenericEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Eduardo Balan on 01/07/2017.
 */
@Entity
//@DynamicUpdate
@Table(name = "tb_informacoes_db", schema = "public")
@SequenceGenerator(name = "tb_informacoes_db_dbin_id_seq", sequenceName = "public.tb_informacoes_db_dbin_id_seq")
public class InformacoesDB extends GenericEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tb_informacoes_db_dbin_id_seq")
    @Column(name = "dbin_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serv_id")
    private Servidor servidor;

    @Column(name = "dbin_listen_addresses")
    private String listenAddresses;

    @Column(name = "dbin_port")
    private String port;

    @Column(name = "dbin_max_connections")
    private String maxConnections;

    @Column(name = "dbin_ssl")
    private String ssl;

    @Column(name = "dbin_shared_buffers")
    private String sharedBuffers;

    @Column(name = "dbin_temp_buffers")
    private String tempBuffers;

    @Column(name = "dbin_work_mem")
    private String workMem;

    @Column(name = "dbin_maintenance_work_mem")
    private String maintenanceWorkMem;

    @Column(name = "dbin_replacement_wort_tuples")
    private String replacementWortTuples;

    @Column(name = "dbin_max_stack_depth")
    private String maxStackDepth;

    @Column(name = "dbin_max_prepared_transactions")
    private String maxPreparedTransactions;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dbin_dthr_cadastro")
    private Date dthr_cadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public String getListenAddresses() {
        return listenAddresses;
    }

    public void setListenAddresses(String listenAddresses) {
        this.listenAddresses = listenAddresses;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(String maxConnections) {
        this.maxConnections = maxConnections;
    }

    public String getSsl() {
        return ssl;
    }

    public void setSsl(String ssl) {
        this.ssl = ssl;
    }

    public String getWorkMem() {
        return workMem;
    }

    public void setWorkMem(String workMem) {
        this.workMem = workMem;
    }

    public String getMaxPreparedTransactions() {
        return maxPreparedTransactions;
    }

    public String getSharedBuffers() {
        return sharedBuffers;
    }

    public void setSharedBuffers(String sharedBuffers) {
        this.sharedBuffers = sharedBuffers;
    }

    public String getTempBuffers() {
        return tempBuffers;
    }

    public void setTempBuffers(String tempBuffers) {
        this.tempBuffers = tempBuffers;
    }

    public void setMaxPreparedTransactions(String maxPreparedTransactions) {
        this.maxPreparedTransactions = maxPreparedTransactions;
    }

    public String getMaintenanceWorkMem() {
        return maintenanceWorkMem;
    }

    public void setMaintenanceWorkMem(String maintenanceWorkMem) {
        this.maintenanceWorkMem = maintenanceWorkMem;
    }

    public String getReplacementWortTuples() {
        return replacementWortTuples;
    }

    public void setReplacementWortTuples(String replacementWortTuples) {
        this.replacementWortTuples = replacementWortTuples;
    }

    public String getMaxStackDepth() {
        return maxStackDepth;
    }

    public void setMaxStackDepth(String maxStackDepth) {
        this.maxStackDepth = maxStackDepth;
    }

    public Date getDthr_cadastro() {
        return dthr_cadastro;
    }

    public void setDthr_cadastro(Date dthr_cadastro) {
        this.dthr_cadastro = dthr_cadastro;
    }
}

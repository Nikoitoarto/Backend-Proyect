package com.ProyectoFormulario.ProyectoFormulario.Entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@MappedSuperclass
 public  abstract class  AbaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "state", nullable = false)
    private Boolean state;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime created_at;

    @Column(name = "update_at", nullable = false)
    private LocalDateTime update_at;

    @Column(name = "deleted_at", nullable = false)
    private LocalDateTime delete_at;

    @Column(name = "created_by", nullable = false)
    private Long created_by;

    @Column(name = "update_by", nullable = false)
    private Long update_by;

    @Column(name = "delete_by", nullable = false)
    private Long delete_by;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(LocalDateTime update_at) {
        this.update_at = update_at;
    }

    public LocalDateTime getDelete_at() {
        return delete_at;
    }

    public void setDelete_at(LocalDateTime delete_at) {
        this.delete_at = delete_at;
    }

    public Long getCreated_by() {
        return created_by;
    }

    public void setCreated_by(Long created_by) {
        this.created_by = created_by;
    }

    public Long getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(Long update_by) {
        this.update_by = update_by;
    }

    public Long getDelete_by() {
        return delete_by;
    }

    public void setDelete_by(Long delete_by) {
        this.delete_by = delete_by;
    }
}



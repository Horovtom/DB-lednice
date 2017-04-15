package com.cvut.fel.horovtom.entities;

import javax.persistence.*;

/**
 * Created by Hermes235 on 15.4.2017.
 */
@Entity
@Table(name = "Fridge", schema = "public", catalog = "wjttfmtg")
public class FridgeEntity {
    private int idFridge;
    private int capacity;
    private String note;

    @Id
    @Column(name = "id_fridge")
    public int getIdFridge() {
        return idFridge;
    }

    public void setIdFridge(int idFridge) {
        this.idFridge = idFridge;
    }

    @Basic
    @Column(name = "capacity")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FridgeEntity that = (FridgeEntity) o;

        if (idFridge != that.idFridge) return false;
        if (capacity != that.capacity) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFridge;
        result = 31 * result + capacity;
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }
}

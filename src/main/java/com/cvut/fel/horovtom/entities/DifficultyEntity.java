package com.cvut.fel.horovtom.entities;

import javax.persistence.*;

/**
 * Created by Hermes235 on 15.4.2017.
 */
@Entity
@Table(name = "Difficulty", schema = "public", catalog = "wjttfmtg")
public class DifficultyEntity {
    private int idDifficulty;
    private String level;

    @Id
    @Column(name = "id_difficulty")
    public int getIdDifficulty() {
        return idDifficulty;
    }

    public void setIdDifficulty(int idDifficulty) {
        this.idDifficulty = idDifficulty;
    }

    @Basic
    @Column(name = "Level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DifficultyEntity that = (DifficultyEntity) o;

        if (idDifficulty != that.idDifficulty) return false;
        if (level != null ? !level.equals(that.level) : that.level != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDifficulty;
        result = 31 * result + (level != null ? level.hashCode() : 0);
        return result;
    }
}

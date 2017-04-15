package com.cvut.fel.horovtom.entities;

import javax.persistence.*;

/**
 * Created by Hermes235 on 15.4.2017.
 */
@Entity
@Table(name = "FoodType", schema = "public", catalog = "wjttfmtg")
public class FoodTypeEntity {
    private int idFoodtype;
    private String typefood;

    @Id
    @Column(name = "id_foodtype")
    public int getIdFoodtype() {
        return idFoodtype;
    }

    public void setIdFoodtype(int idFoodtype) {
        this.idFoodtype = idFoodtype;
    }

    @Basic
    @Column(name = "typefood")
    public String getTypefood() {
        return typefood;
    }

    public void setTypefood(String typefood) {
        this.typefood = typefood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodTypeEntity that = (FoodTypeEntity) o;

        if (idFoodtype != that.idFoodtype) return false;
        if (typefood != null ? !typefood.equals(that.typefood) : that.typefood != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFoodtype;
        result = 31 * result + (typefood != null ? typefood.hashCode() : 0);
        return result;
    }
}

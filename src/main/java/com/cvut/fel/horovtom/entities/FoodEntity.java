package com.cvut.fel.horovtom.entities;

import javax.persistence.*;

/**
 * Created by Hermes235 on 15.4.2017.
 */
@Entity
@Table(name = "Food", schema = "public", catalog = "wjttfmtg")
public class FoodEntity {
    private int idFood;
    private String name;

    @Id
    @Column(name = "id_food")
    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodEntity that = (FoodEntity) o;

        if (idFood != that.idFood) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFood;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

package com.cvut.fel.horovtom.entities;

import javax.persistence.*;

/**
 * Created by Hermes235 on 15.4.2017.
 */
@Entity
@Table(name = "Recipe", schema = "public", catalog = "wjttfmtg")
public class RecipeEntity {
    private int idRecipe;
    private String name;
    private short peopleAmount;
    private String description;

    @Id
    @Column(name = "id_recipe")
    public int getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(int idRecipe) {
        this.idRecipe = idRecipe;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "people_amount")
    public short getPeopleAmount() {
        return peopleAmount;
    }

    public void setPeopleAmount(short peopleAmount) {
        this.peopleAmount = peopleAmount;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeEntity that = (RecipeEntity) o;

        if (idRecipe != that.idRecipe) return false;
        if (peopleAmount != that.peopleAmount) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRecipe;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) peopleAmount;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}

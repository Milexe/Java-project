package by.savin.comprent.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ItemEntity {
    private int id;
    private String name;
    private String description;
    private int pricePerMonth;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price_per_month")
    public int getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(int pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemEntity that = (ItemEntity) o;

        if (id != that.id) return false;
        if (pricePerMonth != that.pricePerMonth) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(description, that.description)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + pricePerMonth;
        return result;
    }
}

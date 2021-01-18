package by.savin.comprent.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class UserToItemEntity {
    private int id;
    private java.sql.Timestamp endDate;
    private User user;
    private int itemId;
    private ItemEntity item;
    private int userId;

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
    @Column(name = "end_date")
    public java.sql.Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(java.sql.Timestamp endDate) {
        this.endDate = endDate;
    }

    public void setItem(int item) {
        this.itemId = item;
    }

    public void setUser(int user) {
        this.userId = user;
    }

    @ManyToOne
    @JoinColumn(name = "item_id", insertable = false, updatable = false)
    public ItemEntity getItem() {
        return item;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    public User getUser() {
        return user;
    }

    @Basic
    @Column(name = "item_id", nullable = false)
    public int getItemId() {
        return itemId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserToItemEntity that = (UserToItemEntity) o;

        if (id != that.id) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }
}

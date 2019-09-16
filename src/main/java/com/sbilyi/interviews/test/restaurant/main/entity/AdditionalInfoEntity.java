package com.sbilyi.interviews.test.restaurant.main.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "menu_item_additional_info")
public class AdditionalInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "additionalInfo")
    private Set<MenuItemEntity> menuItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<MenuItemEntity> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(Set<MenuItemEntity> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) &&
                Objects.equals(id, ((AdditionalInfoEntity) obj).id) &&
                Objects.equals(title, ((AdditionalInfoEntity) obj).title);
    }
}

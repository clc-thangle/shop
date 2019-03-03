package vn.edu.leading.shop.models;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "shop_categories")
public class CategoriesModel {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(name = "category_name",nullable = false)
    private String categoryName;

    private String description;

}

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
public class CategoriesModel extends BaseModel<CategoriesModel>{

    @NotEmpty
    @Column(name = "category_name",nullable = false)
    private String categoryName;

    private String description;

}

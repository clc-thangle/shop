package vn.edu.leading.shop.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Table(name = "shop_products")
public class ProductsModel extends BaseModel<ProductsModel> {
    @NotEmpty
    @Column(name = "product_name", nullable = false)
    private String productName;

    @NotEmpty
    @Column(name = "supplier_id", nullable = false)
    private Long supplierId;

    @NotEmpty
    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    private String unit;

    private Long price;

}
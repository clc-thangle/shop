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
@Table(name = "shop_employees")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(name = "last_name",nullable = false)
    private String lastName;

    @NotEmpty
    @Column(name = "first_name",nullable = false)
    private String firstName;

    @NotEmpty
    @Column(name = "birth_date",nullable = false)
    private String birthDate;

    private String photo;

    private String notes;
}

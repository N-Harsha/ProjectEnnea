package com.valuemedi.projectenna.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "supplier",fetch = FetchType.EAGER)
    List<Product> products;
}

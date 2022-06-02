package com.ssg.ssgproduct.domain.product;

import com.ssg.ssgproduct.domain.product.enums.ProductType;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ProductSpecs {
    public static Specification<Product> withoutProductType(ProductType type) {
        return (Specification<Product>) ((root, query, builder) ->
                builder.notEqual(root.get("ProductType"), type)
        );
    }

    public static Specification<Product> withDateCondition() {
        LocalDate nowDate = LocalDate.now();
        return (Specification<Product>) ((root, query, builder) -> {
            List<Predicate> predicate = new ArrayList<>();
            predicate.add(builder.lessThanOrEqualTo(root.get("ProductDisplayStartTime"), nowDate));
            predicate.add(builder.greaterThanOrEqualTo(root.get("ProductDisplayEndTime"), nowDate));
            return builder.and(predicate.toArray(new Predicate[0]));
        });
    }
}

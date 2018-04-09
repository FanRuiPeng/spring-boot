package mongodb.morphia.model;

import lombok.*;
import org.mongodb.morphia.annotations.*;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Entity("employees")
@Indexes(
        {@Index(value = "salary", fields = {@Field("salary")})}
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    private ObjectId id;

    private String name;

    @Reference
    private Employee manager;

    @Reference
//    @Singular
    private List<Employee> directReports;

    @Property("wage")
    private Double salary;
}

package mongodb.morphia;

import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import mongodb.morphia.model.Employee;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import java.util.List;

public class MorphiaTest {

    @Test
    public void test() {
        final Morphia morphia = new Morphia();
        morphia.mapPackage("mongodb.morphia.model");

        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        final Datastore datastore = morphia.createDatastore(mongoClient, "test");
        datastore.ensureIndexes();
//        insert(datastore);
//        query(datastore);
//        Query<Employee> query = datastore.createQuery(Employee.class);
//        List<Employee> salary = query
//                .field("salary").lessThanOrEq(30000)
//                .asList();
//        salary.forEach(System.out::println);
//        List<Employee> employees = query.filter("salary <=", 30000)
//                .asList();
//        employees.forEach(System.out::println);

//        update(datastore);

        Query<Employee> employeeQuery = datastore.createQuery(Employee.class)
                .field("_id").equal(new ObjectId("5ac8d20f2147932cb0a3f244"));
        WriteResult delete = datastore.delete(employeeQuery);
        int n = delete.getN();
        System.out.println(n);

    }

    private void update(Datastore datastore) {
        Query<Employee> employeeQuery = datastore.createQuery(Employee.class)
                .filter("salary <=", 30000);
        UpdateOperations<Employee> salary = datastore.createUpdateOperations(Employee.class)
                .inc("salary", 10000);
        UpdateResults update = datastore.update(employeeQuery, salary);
    }

    private void query(Datastore datastore) {
        final Query<Employee> query = datastore.createQuery(Employee.class);
        final List<Employee> employees = query.asList();
        employees.forEach(System.out::println);
    }

    private void insert(Datastore datastore) {
        Employee employee = new Employee();
        employee.setName("Elmer Fudd");
        employee.setSalary(50000.0);
        datastore.save(employee);

        Employee employee1 = new Employee();
        employee.setName("Daffy Duck");
        employee.setSalary(40000.0);
        Key<Employee> save1 = datastore.save(employee1);

        Employee employee2 = new Employee();
        employee.setName("Pepé Le Pew");
        employee.setSalary(25000.0);
        Key<Employee> save2 = datastore.save(employee2);

        List<Employee> directReports = employee.getDirectReports();
        directReports.add(employee1);
        directReports.add(employee2);
        datastore.save(employee);
    }
}


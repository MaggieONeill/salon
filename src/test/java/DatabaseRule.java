import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/salon_test", null, null);
    // Make sure to customize the url to have the actual test database name.
   }

  protected void after() {
    try(Connection con = DB.sql2o.open()) {
       String deleteClientQuery = "DELETE FROM clients* ;";
       String deleteHairdresserQuery = "DELETE FROM hairdressers * ;";
       con.createQuery(deleteClientQuery).executeUpdate();
       con.createQuery(deleteHairdresserQuery).executeUpdate();
    }
  }
}

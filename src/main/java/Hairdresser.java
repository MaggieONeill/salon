import org.sql2o.*;
import java.util.List;

public class Hairdresser{

  private int id;
  private String name;

  public String getName(){
    return name;
  }
  public int getId() {
    return id;
  }

  public Hairdresser(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object otherHairdressers) {
    if(!(otherHairdressers instanceof Hairdresser)) {
      return false;
    }else{
      Hairdresser newHairdressers = (Hairdresser) otherHairdressers;
      return this.getName().equals(newHairdressers.getName());
          //this.getId() == newHairdressers.getId();
      }
  }

  public static List<Hairdresser> all() {
    //you wrote "Hairdressers" instead of "Hairdresser". Name has to match the .java file
      try(Connection con =DB.sql2o.open()){
        String sql = "SELECT * FROM hairdressers;";
        return con.createQuery(sql).executeAndFetch(Hairdresser.class);
      }
    }

    public List<Client> getClients() {
      try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE hairdressers_id = :hairdressers_id;";
        return con.createQuery(sql)
            .addParameter("id", this.id)
            .executeAndFetch(Client.class);

      }
    }

  public void save() {
    try (Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO hairdressers (name) VALUES (:name);";
    this.id = (int)con.createQuery(sql, true)
      .addParameter("name", this.name)
      .executeUpdate()
      .getKey();
  }
}

public static Hairdresser find(int id) {
  try (Connection con = DB.sql2o.open()) {
  String sql = "SELECT * FROM hairdressers WHERE id = :id;";
    Hairdresser newHairdressers = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Hairdresser.class);
  return newHairdressers;
  }
}



public void update (String new_name) {
  this.name = new_name;
  try (Connection con = DB.sql2o.open()) {
    String sql = "UPDATE hairdressers SET name = :name WHERE id = :id;";
    con.createQuery(sql)
    .addParameter("name", name)
    .addParameter("id", id)
    .executeUpdate();
  }
}

public void delete() {
  try (Connection con = DB.sql2o.open()) {
  String sql = "DELETE FROM hairdressers WHERE id = :id;";
    con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
  }
}

}//end

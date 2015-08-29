import org.sql2o.*;
import java.util.List;

public class Client{

  private int id;
  private String clients_name;
  private int hairdressers_id;
//  private  Timestamp appointment;
public int getId() {
  return id;
}

public String getClientName(){
  return clients_name;
}

public int getHairdressersId(){
  return hairdressers_id;
}

public Client(String clientName, int hairdressers_id) {
  this.clients_name = clients_name;
  this.hairdressers_id = hairdressers_id;
  //your original statement was "this.hairdressers_id" -you did not have the equals sign, so it did not assign it to anything.
}

public static List<Client> all() {
   String sql = "SELECT * FROM clients";
   try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql)
       .executeAndFetch(Client.class);
   }
 } //this was missing, which caused the @Override error

  //  public static List<Client> returnAllById() {
  //    String sql = "SELECT * FROM clients WHERE hairdressers_id = :hairdressers_id;";
  //    try (Connection con = DB.sql2o.open()) {
  //      return con.createQuery(sql).executeAndFetch(Client.class);
  //  }
  //  }


  @Override
  public boolean equals(Object otherClient) {
    if(!(otherClient instanceof Client)){
      return false;
    }else{
      Client newClient = (Client) otherClient;
      return this.getId() == newClient.getId() &&
             this.getClientName().equals(newClient.getClientName()) &&
             this.getHairdressersId() == newClient.getHairdressersId();
    }
  }


  public void save() {
    String sql = "INSERT INTO clients (clients_name, hairdressers_id) VALUES (:clients_name, :hairdressers_id);"; //i didnt put id in here becuase the data base assigns the id automatically, i don't have to tell it to do that.
    try(Connection con = DB.sql2o.open()){
      this.id = (int) con.createQuery(sql, true) //if im not telling it to assign an id what does this line do then? morgan thinks it checks the id that you are referring to.
      .addParameter("clients_name", clients_name)
      .addParameter("hairdressers_id", hairdressers_id)
      .executeUpdate()
      .getKey();
    }
  }

  public static Client find(int id) {
    try (Connection con = DB.sql2o.open()) {
      String sql = "SELCET * FROM clients WHERE id = :id;";
      Client client = con.createQuery(sql)
                        .addParameter("id", id)
                        .executeAndFetchFirst(Client.class);
      return client;
    }
  }

//   public void updateName(String new_name) {
//     this.name = new_name;
//     String sql = "UPDATE clients SET name = :name WHERE id = :id;";
//     try (Connection con = DB.sql2o.open()) {
//       con.createQuery(sql)
//         .addParameter("name", name)
//         .addParameter("id", id) //not sure if i need this? thought database assigned this automatically?
//         .executeUpdate();
//     }
//   }
//
//   public void updateHairdresser_id( int hairdresser_id){
//     try(Connection con = DB.sql2o.open()) {
//       String sql = "UPDATE clients SET hairdressers_id = :hairdressers_id WHERE id = :id;";
//       con.createQuery(sql)
//       .addParameter("hairdressers_id", hairdressers_id)
//       .addParameter("id", id)
//       .executeUpdate();
//     }
//   }
//
//   public void delete() {
//   try (Connection con = DB.sql2o.open()) {
//     String sql = "DELETE FROM clients WHERE id = :id;";
//     con.createQuery(sql)
//       .addParameter("id", id)
//       .executeUpdate();
//   }
// }
//
// }
}

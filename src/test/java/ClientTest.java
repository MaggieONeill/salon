import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;

public class ClientTest{

  @Rule
  public DatabaseRule database = new DatabaseRule();


  @Test
  public void all_emptyAtFirst() {
      assertEquals(Client.all().size(), 0);
   }

   @Test
   public void all_returnsSavedObjects() {
     Client newClient = new Client("Megan", 1);
     newClient.save();
     assertEquals(Client.all().size(), 1);
   }

   @Test
   public void getName_returnsClients_nameMegan(){
     Client newClient = new Client ("Megan", 1);
     assertEquals("Megan", newClient.getClientName());
   }

   @Test
   public void getHairdressers_id_returnsCorrectId(){
     Client newClient = new Client("Megan", 1);
     assertEquals(1, newClient.getHairdressersId());
   }

   @Test
   public void save_addsClientToDatabase(){
     Client newClient = new Client("Megan", 1);
     newClient.save();
     assertEquals(true, Client.all().get(0).equals(newClient));
   }

   @Test
    public void find_findsClientById(){
     Client newClient = new Client("Megan", 1);
     newClient.save();
     Client savedClient = Client.find(newClient.getId());
     assertEquals(savedClient, newClient);
   }

   
 //   @Test
 // public void equals_overrideIfClientInformationIsDuplicated_true() {
 //   Client newClient = new Client("Megan", 1);
 //   Client oldClient = new Client("Megan", 1);
 //   assertTrue(newClient.equals(oldClient));
 // }
   //
  //  @Test
  //  public void getNameReturnsName(){
  //    Client client = new Client("Megan", 1);
  //    assertEquals("Megan", client.getClientName());
  //  }

 }

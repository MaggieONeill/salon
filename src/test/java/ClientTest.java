import org.junit.*;
import static org.junit.Assert.*;


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
 public void equals_overrideIfClientInformationIsDuplicated_true() {
   Client newClient = new Client("Megan", 1);
   Client oldClient = new Client("Megan", 1);
   assertTrue(newClient.equals(oldClient));
 }
   //
  //  @Test
  //  public void getNameReturnsName(){
  //    Client client = new Client("Megan", 1);
  //    assertEquals("Megan", client.getClientName());
  //  }

 }

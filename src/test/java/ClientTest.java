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

 }

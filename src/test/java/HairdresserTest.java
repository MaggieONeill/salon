import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;


public class HairdresserTest{

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void getName_returnsName(){
    Hairdresser newHairdresser = new Hairdresser("Ann");
    assertEquals("Ann", newHairdresser.getName());
  }

  @Test
  public void all_emptyAtFirst(){
    assertEquals( Hairdresser.all().size(), 0);
  }

  @Test
  public void equals_returnTrueIfTypesMatch(){
    Hairdresser firstHairdresser = new Hairdresser ("Ann");
    Hairdresser secondHairdresser = new Hairdresser ("Ann");
    assertEquals(true, firstHairdresser.equals(secondHairdresser));
  }

  @Test
  public void getId_returnsCorrectId() {
    Hairdresser newHairdresser = new Hairdresser("Ann");
    newHairdresser.save();
    Hairdresser savedHairdresser = Hairdresser.find(newHairdresser.getId());
    assertEquals(savedHairdresser, newHairdresser);
  }

  @Test
  public void update_Hairdresser() {
    Hairdresser newHairdresser = new Hairdresser("Ann");
    newHairdresser.save();
    String name = "Buck";
    newHairdresser.update(name);
    assertTrue(Hairdresser.all().get(0).getName().equals(name));
  }
}//end

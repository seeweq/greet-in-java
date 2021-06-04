package greet;
import static org.junit.jupiter.api.Assertions.assertEquals;

import net.greet.Greeter;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class greeterTest {
    @Test
   public void checkIfGreetUserIsAdded(){

        Greeter greetUser = new Greeter();
        greetUser.greet("sivu","IsiXhosa");
        assertEquals(1,greetUser.greeted("sivu"));
   }
   @Test
   public void checkIfUniqueUsersAreAdded(){
       Greeter greetUniqueUsers = new Greeter();
       greetUniqueUsers.greet("zola","French");
       greetUniqueUsers.greet("charl","IsiXhosa");
       assertEquals(2,greetUniqueUsers.counter());
   }
   @Test
    public void removeAUserFromList(){
       Greeter greetAUser = new Greeter();
       greetAUser.greet("vuyo", "");
       greetAUser.greet("kagiso","IsiXhosa");
       greetAUser.clear("vuyo");
       assertEquals(1,greetAUser.counter());
   }


}

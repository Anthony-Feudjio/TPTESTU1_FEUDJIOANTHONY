import static org.junit.jupiter.api.Assertions.assertEquals;  // Import JUnit 5 assertions
import static org.junit.jupiter.api.Assertions.assertFalse;                // Import JUnit 5 test annotation
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
public class UserTest {

    @Test
    public void testAddUserWithInvalidEmail() {
        User user = new User(1, "John Doe", 30, "invalid_email", "1234567890", "City", 100.0);
        assertThrows(EmailInvalidException.class, () -> UserManager.addUser(user));
    }

    @Test
    public void testDeleteUserWithNonExistentId() {
        assertThrows(DeletionInvalidException.class, () -> UserManager.deleteUser(999));
    }

    @Test
    public void testListUsers() {
        UserManager.listUsers();
    }

    @Test
    public void testDisplayUser() {
        UserManager.displayUser(1);
    }
    @Test
    public void testAnalyseSoldeGeneralWithNegativeBalance() {
        assertThrows(NegativeGeneralBalanceException.class, () -> {
            User user1 = new User(1, "John", 25, "john@example.com", "123", "City", -500.0);
            User user2 = new User(2, "Jane", 30, "jane@example.com", "456", "City", -200.0);
            UserManager.addUser(user1);
            UserManager.addUser(user2);
            UserManager.analyseSoldeGeneral();
        });
    }

    @Test
    public void testGetRichestUser() {
        User user1 = new User(1, "John", 25, "john@example.com", "123", "City", 500.0);
        User user2 = new User(2, "Jane", 30, "jane@example.com", "456", "City", 200.0);
        UserManager.addUser(user1);
        UserManager.addUser(user2);
        assertEquals(user1, UserManager.getRichestUser());
    }
}

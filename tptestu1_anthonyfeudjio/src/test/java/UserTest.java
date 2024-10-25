
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
}

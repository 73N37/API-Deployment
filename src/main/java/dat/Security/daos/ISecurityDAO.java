package dat.Security.daos;

import dat.Security.entities.User;
import dat.Security.exceptions.ValidationException;
import dk.bugelhartmann.UserDTO;

public interface ISecurityDAO {
    UserDTO getVerifiedUser(String username, String password) throws ValidationException;
    User createUser(String username, String password);
    User postRole(UserDTO user, String newRole);
}

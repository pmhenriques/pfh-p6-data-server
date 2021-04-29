package pt.uc.dei.paj.dao;

import com.google.common.hash.Hashing;
import pt.uc.dei.paj.entity.Admin;
import pt.uc.dei.paj.exceptions.*;

import javax.ejb.Stateless;
import java.nio.charset.StandardCharsets;

@Stateless
public class AdminDao extends AbstractUserDao<Admin> {

    private static final long serialVersionUID  = 3338979774903655118L;

    public AdminDao() {
        super(Admin.class);
    }

    /**
     * Adds a Admin to the database.
     *
     * @param username
     * @param password
     * @return admin
     */
    public Admin add(String username, String password) {
        if (findUsername(username) != null) {
            throw new DuplicatedEntityException("Admin with username " + username + " already exists.");
        }

        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString());

        persist(admin);

        return admin;
    }
}

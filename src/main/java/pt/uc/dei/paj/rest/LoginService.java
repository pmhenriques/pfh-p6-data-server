package pt.uc.dei.paj.rest;

import pt.uc.dei.paj.dao.AdminDao;
import pt.uc.dei.paj.dao.VoterDao;
import pt.uc.dei.paj.exceptions.AuthenticationException;
import pt.uc.dei.paj.rest.controllers.requests.AdminLoginRequest;
import pt.uc.dei.paj.rest.controllers.requests.VoterLoginRequest;
import pt.uc.dei.paj.rest.controllers.responses.AdminLoginResponse;
import pt.uc.dei.paj.rest.controllers.responses.VoterLoginResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ForbiddenException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class manages login and logout from users: Admins and Voters.
 * Login service creates a Login response.
 * Login service depends on {@link AdminDao}, {@link VoterDao} (data access object).
 * This class contains two concurrent hash maps that store all active tokens from a user:
 * key is username and value is token for admins and key civilIDNum and token for voters.
 * Username identifies one admin (is unique), and one username stores one token.
 * CivilIDnum identifies a voter (is unique), and one civilIDnum stores a token.
 */

@ApplicationScoped
public class LoginService {

    /**
     * Hash map stores all active tokens from a Admin (persisted in memory).
     * Key: username
     * Value: token
     */
    private final Map<String, String> activeAdminTokens = new ConcurrentHashMap<>();
    /**
     * Hash map stores all active tokens from a voter (persisted in memory).
     * Key: civilIDnum
     * Value: token
     */
    private final Map<String, String> activeVoterTokens = new ConcurrentHashMap<>();

    @Inject
    private AdminDao adminDao;

    @Inject
    private VoterDao voterDao;

    /**
    * Validates token from user:
    * for each user, verifies if the token is contained in the map of active tokens.
    * If the token is contained in the map, the token is still valid and
    * the user has not logged out from the application.
    *
    * @param token token
    * @return true if token is active
    */
    public boolean validate(String token) {
        return activeAdminTokens.containsValue(token) ||
                activeVoterTokens.containsValue(token);
    }

    /**
     * Login of admin.
     * If token already exists returns login response for the existent token.
     * If token does not exist for a given admin, generates a active token
     *
     * @param loginRequest login request
     * @return login response
     */
    public AdminLoginResponse loginAdmin(AdminLoginRequest loginRequest) {

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        boolean valid = adminDao.isAdminCredentialsValid(username, password);

        //if token is active, user logs using the active token
        //returns the value
        final String activeToken = activeAdminTokens.get(username);
        if (activeToken != null && valid){

            return new AdminLoginResponse(activeToken);
        }

        //if token is not active, user logs in and a token is generated
        if (valid) {

            final String newToken = UUID.randomUUID().toString();
            activeAdminTokens.put(loginRequest.getUsername(), newToken);

            return new AdminLoginResponse(newToken);
        }

        throw new AuthenticationException();
    }

    /**
     * Logout of admin.
     * Removes active admin token from the concurrent hash map.
     * If token is null throws AuthenticationException (RuntimeException).
     *
     * @param authorizationToken authorization token
     */
    public void logoutAdmin(String authorizationToken) {
        //Removes key (username) and corresponding value (token) from map of active tokens
        //Returns the value to which this map previously associated the key (token),
        //or null if the map contained no mapping for the key.
        String username = activeAdminTokens.entrySet().stream()
                .filter(e -> e.getValue().equals(authorizationToken))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseGet(() -> null);
        final String token = activeAdminTokens.remove(username);
        if (token != null) {
            return;
        }
        throw new AuthenticationException();
    }

    /**
     * Verifies if a admin with a given username is authorized for the associated token.
     *
     * @param token    token
     * @param username username
     */
    public void checkAdminAuthorization(String token, String username) {

        if (!activeAdminTokens.get(username).equals(token)) {
            throw new ForbiddenException();
        }
    }

    /**
     * Login of voter.
     * If token already exists returns login response for the existent token.
     * If token does not exist for a given admin, generates a active token
     *
     * @param voterLoginRequest
     * @return VoterLoginResponse
     */
    public VoterLoginResponse loginVoter(VoterLoginRequest voterLoginRequest) {

        String civilIdNum = voterLoginRequest.getCivilIdNumber();
        boolean valid = voterDao.isCivilIdNumValid(civilIdNum);

        //if token is active, user logs using the active token
        //returns the value
        final String activeToken = activeVoterTokens.get(civilIdNum);
        if (activeToken != null & valid) {
            return new VoterLoginResponse(activeToken);
        }

        throw new AuthenticationException();
    }

    /**
     * Verifies if a voter with a given civilIDnum is authorized for the associated token.
     *
     * @param token
     * @param civilIDnum
     */
    public void checkVoterAuthorization(String token, String civilIDnum) {

        if (!activeVoterTokens.get(civilIDnum).equals(token)) {
            throw new ForbiddenException();
        }
    }

    /**
     * Logout of voter.
     * Removes active voter token from the concurrent hash map.
     * If token is null throws AuthenticationException (RuntimeException).
     *
     * @param authorizationToken
     */
    public void logoutVoter(String authorizationToken) {
        //Removes key (username) and corresponding value (token) from map of active tokens
        //Returns the value to which this map previously associated the key (token),
        //or null if the map contained no mapping for the key.
        String civilIDnum = activeAdminTokens.entrySet().stream()
                .filter(e -> e.getValue().equals(authorizationToken))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseGet(() -> null);
        final String token = activeAdminTokens.remove(civilIDnum);
        if (token != null) {
            return;
        }
        throw new AuthenticationException();
    }
}

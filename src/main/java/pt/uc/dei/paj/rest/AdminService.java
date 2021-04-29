package pt.uc.dei.paj.rest;

import pt.uc.dei.paj.dao.AdminDao;
import pt.uc.dei.paj.entity.Admin;
import pt.uc.dei.paj.rest.controllers.requests.AdminRegisterRequest;
import pt.uc.dei.paj.rest.controllers.responses.AdminResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * This class manages entity: Admin
 * Service creates a response.
 * Admin service depends on {@link AdminDao} data access object
 */

@ApplicationScoped
public class AdminService {

    @Inject
    private AdminDao adminDao;

    /**
     * Creates a response to the request: create a new Admin
     * @param adminRegisterRequest request
     * @return response
     */

    public AdminResponse create(AdminRegisterRequest adminRegisterRequest) {
        Admin admin = adminDao.add(
                adminRegisterRequest.getUsername(),
                adminRegisterRequest.getPassword());

        AdminResponse adminResponse = new AdminResponse();
        adminResponse.setUsername(admin.getUsername());
        adminResponse.setPassword(admin.getPassword());

        return adminResponse;
    }
}

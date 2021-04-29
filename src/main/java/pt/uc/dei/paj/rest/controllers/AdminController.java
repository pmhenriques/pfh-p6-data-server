package pt.uc.dei.paj.rest.controllers;

import pt.uc.dei.paj.exceptions.*;
import pt.uc.dei.paj.rest.*;
import pt.uc.dei.paj.rest.controllers.headers.HttpHeaders;
import pt.uc.dei.paj.rest.controllers.requests.*;
import pt.uc.dei.paj.rest.controllers.responses.*;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * This class controls rest service mapping for Entity: Admin.
 * Receives a request and returns a response.
 * AdminController depends on {@link LoginService}.
 */

@Path("/admins") //path specifies the service: /admin
public class AdminController {

    @Inject
    private LoginService loginService;

    @Inject
    private AdminService adminService;

    public AdminController() {
    }

    /**
     * Returns a response: register a new Admin
     *
     * @param adminRegisterRequest
     * @return response
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid AdminRegisterRequest adminRegisterRequest) {
        try {
            adminService.create(adminRegisterRequest);

            return Response
                    .status(201) //created
                    .build();
        } catch (RuntimeException e) {
            return Response
                    .status(400) //bad request
                    .entity(e.getMessage())
                    .build();
        }
    }

    /**
     * Returns a response: do login as admin.
     *
     * @param loginRequest login request
     * @return response
     */

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(@Valid AdminLoginRequest loginRequest) {
        try {
            AdminLoginResponse adminLoginResponse = loginService.loginAdmin(loginRequest);
            return Response
                    .status(200) //login OK
                    .entity(adminLoginResponse)
                    .build();
        } catch (AuthenticationException e) {
            return Response
                    .status(401) //unauthorized
                    .entity(e.getMessage())
                    .build();
        }
    }

    /**
     * Returns a response: do logout as admin.
     *
     * @param authorizationToken authorization token
     * @return response
     */
    @POST
    @Path("/logout")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout(@HeaderParam(HttpHeaders.TOKEN) String authorizationToken) {

        try {
            loginService.logoutAdmin(authorizationToken);

            return Response
                    .status(200) //ok
                    .build();
        } catch (AuthenticationException e) {
            return Response
                    .status(401) //unauthorized
                    .entity(e.getMessage())
                    .build();
        }
    }

    /**
     * Returns a response: create new election
     */

}

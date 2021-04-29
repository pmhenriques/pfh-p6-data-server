package pt.uc.dei.paj.rest.controllers;

import pt.uc.dei.paj.entity.Voter;
import pt.uc.dei.paj.exceptions.AuthenticationException;
import pt.uc.dei.paj.rest.LoginService;
import pt.uc.dei.paj.rest.VoterService;
import pt.uc.dei.paj.rest.controllers.headers.HttpHeaders;
import pt.uc.dei.paj.rest.controllers.requests.VoterLoginRequest;
import pt.uc.dei.paj.rest.controllers.requests.VoterRegisterRequest;
import pt.uc.dei.paj.rest.controllers.responses.VoterLoginResponse;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * This class controls rest service mapping for Entity: Voter.
 * Receives a request and returns a response.
 * VoterController depends on {@link VoterService} and {@link LoginService}.
 */
@Path("/voters")
public class VoterController {

    @Inject
    private VoterService voterService;

    @Inject
    private LoginService loginService;

    public VoterController() {
    }

    /**
     * Returns a response: register a new voter.
     *
     * @param voterRegisterRequest voter request
     * @return response
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid VoterRegisterRequest voterRegisterRequest) {
        try {
            voterService.create(voterRegisterRequest);

            return Response
                    .status(201) //created
                    .build();
        } catch (RuntimeException e){
            return Response
                    .status(400) //bad request
                    .entity(e.getMessage())
                    .build();
        }
    }

    /**
     * Returns a response: do login as voter.
     *
     * @param voterLoginRequest
     * @return reponse
     */
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(@Valid VoterLoginRequest voterLoginRequest) {
        try {
            VoterLoginResponse voterLoginResponse = loginService.loginVoter(voterLoginRequest);

            return Response
                    .status(200) //ok
                    .entity(voterLoginResponse)
                    .build();
        } catch (AuthenticationException e){
            return Response
                    .status(401) //unauthorized
                    .entity(e.getMessage())
                    .build();
        }
    }

    /**
     * Returns a response: do logout as voter.
     *
     * @param authorizationToken authorization token
     * @return response
     */
    @POST
    @Path("/logout")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout(@HeaderParam(HttpHeaders.TOKEN) String authorizationToken) {
        try {
            loginService.logoutVoter(authorizationToken);

            return Response
                    .status(200) //ok
                    .build();
        } catch (AuthenticationException e){
            return Response
                    .status(401) //unauthorized
                    .entity(e.getMessage())
                    .build();
        }
    }

}


package tech.buildrun.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.buildrun.lambda.request.LoginRequest;
import tech.buildrun.lambda.response.LoginResponse;

import java.io.IOException;
import java.io.UncheckedIOException;

public class Handler implements
        RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private static ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request,
                                                      Context context) {
        var logger = context.getLogger();

        logger.log("Request received - " + request.getBody());

        try {
            var loginRequest = objectMapper.readValue(request.getBody(), LoginRequest.class);

            boolean isAuthorized = false;

            if ("admin".equalsIgnoreCase(loginRequest.username())
                    && "123".equalsIgnoreCase(loginRequest.password())){
                isAuthorized = true;
            }

            var loginResponse = new LoginResponse(isAuthorized);


            return new APIGatewayProxyResponseEvent()
                .withStatusCode(200)
                .withBody(objectMapper.writeValueAsString(loginResponse))
                .withIsBase64Encoded(false);

        } catch (IOException e) {
            throw new UncheckedIOException(e);

        }
    }

}

package io.mindit.aws.handler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.fasterxml.jackson.databind.ObjectMapper;


import io.mindit.aws.handler.response.GatewayResponse;


/**
 * A simple handler returning input object as a json.
 */
public class EchoHandler implements RequestHandler<Object, Object> {

    static final Logger logger = LogManager.getLogger(EchoHandler.class);

    public Object handleRequest(final Object input, final Context context) {

        logger.info("EchoHttpHandler invoked");

        Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            headers.put("X-Custom-Header", "application/json");
        
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return new GatewayResponse(objectMapper.writeValueAsString(input), headers, 200);
            }catch(Exception e){
                e.printStackTrace();
                return e.getMessage();
            }
    }

}

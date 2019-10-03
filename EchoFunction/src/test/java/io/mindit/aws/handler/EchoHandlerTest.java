package io.mindit.aws.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.w3c.dom.NameList;

import lombok.Getter;
import lombok.Setter;

import io.mindit.aws.handler.response.GatewayResponse;

public class EchoHandlerTest {
    
    class Street{

        @Getter @Setter
        String name;

        @Getter @Setter 
        int number;

        public Street(String name, int number){
            this.name = name;
            this.number = number;
        }
    }

    @Test
    public void successfulResponse() {
        EchoHandler app = new EchoHandler();

        Street street = new Street("Jump Street", 21);
        GatewayResponse result = (GatewayResponse) app.handleRequest(street, null);
        
        assertEquals(result.getStatusCode(), 200);
        assertEquals(result.getHeaders().get("Content-Type"), "application/json");
        String content = result.getBody();
        assertNotNull(content);
        System.out.print(content);
        assertTrue(content.equals("{\"name\":\"Jump Street\",\"number\":21}"));
    }
}

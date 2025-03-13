/*
package gpstest.gpscordbackend.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// XmlControllerTest.java
@SpringBootTest
@AutoConfigureMockMvc
class XmlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void shouldReturnXmlWithAuthHeader() throws Exception {
        String jsonRequest = """
        {
            "id": 1,
            "value": "test"
        }
        """;

        mockMvc.perform(post("/api/xml")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(header().exists("X-Auth-Token"))
                .andExpect(content().contentType(MediaType.APPLICATION_XML))
                .andExpect(xpath("/XmlResponse/status").string("success"))
                .andExpect(xpath("/XmlResponse/data/id").number(1.0));
    }

    @Test
    void shouldReturn401WhenUnauthorized() throws Exception {
        mockMvc.perform(get("/api/protected"))
                .andExpect(status().isUnauthorized())
                .andExpect((ResultMatcher) jsonPath("$.status").value("Unauthorized"));
    }
}
*/

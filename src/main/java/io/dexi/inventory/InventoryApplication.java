package io.dexi.inventory;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@SpringBootApplication
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}
}

@RestController
class WebController {
    private Logger LOGGER = LoggerFactory.getLogger(WebController.class);


    @GetMapping("/hosts")
    public Map<String, Group> hosts() {
        Map<String, Group> result = new HashMap<>();
        Group databases = new Group();
        databases.setHosts(Arrays.asList("host1.example.com", "host2.example.com"));
        Group webservers = new Group();
        webservers.setHosts(Arrays.asList("host3.example.com", "host4.example.com"));
        Map<String, String> vars = new HashMap<>();
        vars.put("a", "true");
        databases.setVars(vars);
        result.put("databases", databases);
        result.put("webservers", webservers);
        return result;
    }

    @GetMapping("/hosts/{host}")
    public Map<String, String> host(@PathVariable("host") String host) {
        LOGGER.info("--host: {}", host);
        Map<String, String> result = new HashMap<>();
        result.put("favcolor", "red");
        result.put("ntpserver", "wolf.example.com");
        return result;
    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
class Group {
    private List<String> hosts = new ArrayList<>();
    private Map<String, String> vars = null;
    private List<String> children = null;
}

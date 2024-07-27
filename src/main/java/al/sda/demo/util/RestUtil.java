package al.sda.demo.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class RestUtil {
    public static URI locationBuilder(String path) {
        return ServletUriComponentsBuilder.fromCurrentRequestUri()
                       .path(path)
                       .build()
                       .toUri();
    }
}

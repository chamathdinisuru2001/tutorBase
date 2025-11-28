package com.tutorbase.backend.config;


import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "duxl19tai");
        config.put("api_key", "734529375672821");
        config.put("api_secret","_0NX-4GorX_q9LCOIizuKmFuOAw");
        return new Cloudinary(config);

    }
}

package com.example.demo.config;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;

@Configuration
public class DependencyConfig {

//    @Bean
//    public HttpMessageConverters customConverters() {
//        MarshallingHttpMessageConverter xmlConverter =new MarshallingHttpMessageConverter();
//        XStreamMarshaller xstream = new XStreamMarshaller();
//        xmlConverter.setMarshaller(xstream);
//        xmlConverter.setUnmarshaller(xstream);
//
//        return new HttpMessageConverters(xmlConverter);
//    }
}

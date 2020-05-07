package br.com.tokiomarine.seguradora.avaliacao;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:estudantes/listar");
        registry.addViewController("/index").setViewName("redirect:estudantes/listar");
        registry.addViewController("/index.*").setViewName("redirect:estudantes/listar");
    }

}

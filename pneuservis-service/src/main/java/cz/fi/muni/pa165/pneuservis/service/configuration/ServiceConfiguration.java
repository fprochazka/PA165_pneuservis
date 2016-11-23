package cz.fi.muni.pa165.pneuservis.service.configuration;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import cz.fi.muni.pa165.pneuservis.PersistenceSampleApplicationContext;

/**
 * @author  Ivan Moscovic on 23.11.2016.
 */

@Configuration
@Import(PersistenceSampleApplicationContext.class)
@ComponentScan(value = "cz.fi.muni.pa165.pneuservis.service")
public class ServiceConfiguration {

    @Bean
    public Mapper dozer(){
        return new DozerBeanMapper();
    }
}

package cz.fi.muni.pa165.pneuservis.service.configuration;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import cz.fi.muni.pa165.pneuservis.PersistenceSampleApplicationContext;
import cz.fi.muni.pa165.pneuservis.dto.PersonDTO;
import cz.fi.muni.pa165.pneuservis.dto.ServiceDTO;
import cz.fi.muni.pa165.pneuservis.entity.Person;
import cz.fi.muni.pa165.pneuservis.entity.Service;
import org.dozer.loader.api.BeanMappingBuilder;

/**
 * @author  Ivan Moscovic on 23.11.2016.
 */

@Configuration
@Import(PersistenceSampleApplicationContext.class)
@ComponentScan(basePackages = "cz.fi.muni.pa165.pneuservis.service")
public class ServiceConfiguration {

    @Bean
    public Mapper dozer(){
        DozerBeanMapper dozer = new DozerBeanMapper();
        dozer.addMapping(new DozerCustomConfig());
        return dozer;
    }

    public class DozerCustomConfig extends BeanMappingBuilder {

        @Override
        protected void configure() {
            mapping(Person.class, PersonDTO.class);
            mapping(Service.class, ServiceDTO.class);
        }
    }
}

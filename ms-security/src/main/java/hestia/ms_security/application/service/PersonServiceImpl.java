package hestia.ms_security.application.service;

import hestia.ms_security.application.ports.in.PersonsService;
import hestia.ms_security.application.ports.out.PersonBusClient;
import hestia.ms_security.application.ports.out.PersonClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonsService {

    private PersonClient personClient;
    private PersonBusClient busClient;

    @Override
    public void getPersons() {
        personClient.findAllPersons();
    }

    @Override
    public void getBusiness() {
        busClient.findAllPersonsBus();
    }

}
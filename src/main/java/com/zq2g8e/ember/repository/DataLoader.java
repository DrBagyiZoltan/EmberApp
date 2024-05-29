package com.zq2g8e.ember.repository;
import com.zq2g8e.ember.entity.EmberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmberRepository emberRepository;

    @Autowired
    public DataLoader(EmberRepository emberRepository) {
        this.emberRepository = emberRepository;
    }

    @Override
    public void run(String... args) {

        EmberEntity ember1 = new EmberEntity("Geza", 1994, "Ferfi");
        EmberEntity ember2 = new EmberEntity("Laci",1992, "Ferfi");
        EmberEntity ember3 = new EmberEntity("Teri",1988, "No");
        EmberEntity ember4 = new EmberEntity("Kati", 2000, "No");

        emberRepository.save(ember1);
        emberRepository.save(ember2);
        emberRepository.save(ember3);
        emberRepository.save(ember4);
    }
}
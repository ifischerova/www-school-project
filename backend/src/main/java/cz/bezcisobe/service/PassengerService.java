package cz.bezcisobe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.bezcisobe.model.Passenger;
import cz.bezcisobe.model.PassengerId;
import cz.bezcisobe.repository.PassengerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }

    public Optional<Passenger> findById(PassengerId id) {
        return passengerRepository.findById(id);
    }

    public Passenger save(Passenger cestujici) {
        return passengerRepository.save(cestujici);
    }

    public void deleteById(PassengerId id) {
        passengerRepository.deleteById(id);
    }
}
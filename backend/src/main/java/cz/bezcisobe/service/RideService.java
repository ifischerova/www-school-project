package cz.bezcisobe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.bezcisobe.model.Ride;
import cz.bezcisobe.repository.RideRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RideService {
    @Autowired
    private RideRepository rideRepository;

    public List<Ride> findAll() {
        return rideRepository.findAll();
    }

    public Optional<Ride> findById(Long id) {
        return rideRepository.findById(id);
    }

    public Ride save(Ride spolujizda) {
      
        return rideRepository.save(spolujizda);
    }

    public void deleteById(Long id) {
        rideRepository.deleteById(id);
    }
}
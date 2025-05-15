package cz.bezcisobe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.bezcisobe.model.RideRequest;
import cz.bezcisobe.repository.RideRequestRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RideRequestService {
    @Autowired
    private RideRequestRepository rideRequestRepository;

    public List<RideRequest> findAll() {
        return rideRequestRepository.findAll();
    }

    public Optional<RideRequest> findById(Long id) {
        return rideRequestRepository.findById(id);
    }

    public List<RideRequest> findByUserId(Long userId) {
        return rideRequestRepository.findByUserID(userId);
    }

    public RideRequest save(RideRequest request) {
        return rideRequestRepository.save(request);
    }

    public RideRequest updateRequest(Long id, RideRequest requestDetails) {
        Optional<RideRequest> request_opt = findById(id);
        if (!request_opt.isPresent()) {
          throw new RuntimeException("No such request");
        }
        RideRequest request = request_opt.get();

        if (requestDetails.getDepartureDate() != null) {
            request.setDepartureDate(requestDetails.getDepartureDate());
        }
        if (requestDetails.getDepartureTime() != null) {
            request.setDepartureTime(requestDetails.getDepartureTime());
        }
        if (requestDetails.getDepraturePlace() != null) {
            request.setDepraturePlace(requestDetails.getDepraturePlace());
        }
        if (requestDetails.getNumSeats() != null) {
            request.setNumSeats(requestDetails.getNumSeats());
        }
        if (requestDetails.getNote() != null) {
            request.setNote(requestDetails.getNote());
        }
        
        return rideRequestRepository.save(request);
    }

    public void deleteById(Long id) {
        rideRequestRepository.deleteById(id);
    }
}
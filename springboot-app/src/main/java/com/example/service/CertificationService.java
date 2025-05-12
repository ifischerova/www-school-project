package com.example.service;

import com.example.model.Certifikace;
import com.example.repository.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CertificationService {
    @Autowired
    private CertificationRepository certificationRepository;

    public List<Certifikace> findAll() {
        return certificationRepository.findAll();
    }

    public Optional<Certifikace> findById(Long id) {
        return certificationRepository.findById(id);
    }

    public Certifikace save(Certifikace certification) {
        return certificationRepository.save(certification);
    }

    public void deleteById(Long id) {
        certificationRepository.deleteById(id);
    }
}
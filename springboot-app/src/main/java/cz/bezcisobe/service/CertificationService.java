package cz.bezcisobe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cz.bezcisobe.model.Certification;
import cz.bezcisobe.repository.CertificationRepository;
import cz.bezcisobe.mapper.CertificationMapper;
import cz.bezcisobe.dto.request.CreateCertificationRequest;
import cz.bezcisobe.dto.response.CertificationResponse;
import cz.bezcisobe.dto.response.CertificationListResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CertificationService {
    @Autowired
    private CertificationRepository certificationRepository;
    
    @Autowired
    private CertificationMapper certificationMapper;

    public CertificationListResponse findAll() {
        List<Certification> certifications = certificationRepository.findAll();
        CertificationListResponse response = new CertificationListResponse();
        response.setCertifications(certifications.stream()
                .map(certificationMapper::toResponse)
                .collect(Collectors.toList()));
        response.setTotal(certifications.size());
        return response;
    }

    public Optional<CertificationResponse> findById(Long id) {
        return certificationRepository.findById(id)
                .map(certificationMapper::toResponse);
    }

    public CertificationResponse create(CreateCertificationRequest request) {
        Certification certification = certificationMapper.toEntity(request);
        Certification saved = certificationRepository.save(certification);
        return certificationMapper.toResponse(saved);
    }

    public Optional<CertificationResponse> update(Long id, CreateCertificationRequest request) {
        return certificationRepository.findById(id)
                .map(existing -> {
                    existing.setName(request.getName());
                    return certificationMapper.toResponse(certificationRepository.save(existing));
                });
    }

    public void deleteById(Long id) {
        certificationRepository.deleteById(id);
    }
}
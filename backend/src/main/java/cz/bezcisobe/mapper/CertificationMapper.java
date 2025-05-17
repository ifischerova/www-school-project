package cz.bezcisobe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import cz.bezcisobe.model.Certification;
import cz.bezcisobe.dto.request.CreateCertificationRequest;
import cz.bezcisobe.dto.response.CertificationResponse;

@Mapper(componentModel = "spring")
public interface CertificationMapper {
    @Mapping(target = "id", source = "ID")
    CertificationResponse toResponse(Certification certification);
    
    @Mapping(target = "ID", ignore = true)
    @Mapping(target = "races", ignore = true)
    Certification toEntity(CreateCertificationRequest request);
}
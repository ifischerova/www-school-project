package cz.bezcisobe.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class CertificationListResponse {
    private List<CertificationResponse> certifications;
    private long total;
}
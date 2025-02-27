package MODEL.DTO.RESPONSE;

import java.time.Instant;

public record ExceptionResponseDTO(String message, Instant timestamp) {
}

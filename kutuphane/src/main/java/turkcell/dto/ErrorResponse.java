package turkcell.dto;

import lombok.*;

@Getter @Setter @AllArgsConstructor
public class ErrorResponse {
    private String title;
    private String type;
    private String message;
}

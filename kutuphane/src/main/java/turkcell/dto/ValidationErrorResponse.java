package turkcell.dto;

import lombok.*;
import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ValidationErrorResponse {
    private String argument; // Hangi alan hatalı? (Örn: "ad")
    private List<String> messages; // Hatalar neler? (Örn: ["Boş olamaz", "En az 2 karakter olmalı"])
}

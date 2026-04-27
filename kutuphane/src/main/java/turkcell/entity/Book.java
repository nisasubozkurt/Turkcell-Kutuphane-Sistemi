package turkcell.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "kitaplar")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String baslik;
    private String yazar;
    private String isbn;
    private Integer sayfaSayisi;
}

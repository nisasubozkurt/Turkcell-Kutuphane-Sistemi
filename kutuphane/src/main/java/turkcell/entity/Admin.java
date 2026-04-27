package turkcell.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gorevli")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ad;
    private String soyad;
    private String kullaniciAdi;
    private String sifre;
}

package turkcell.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ogrenciler")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ad;
    private String soyad;
    @Column(name = "ogrenci_no")
    private String studentNo;
}

package turkcell.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "ogrenciler")
@Getter @Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Öğrenci adı boş bırakılamaz!")
    @Size(min = 2, message = "Öğrenci adı en az 2 karakter olmalıdır!")
    private String ad;

    @NotBlank(message = "Öğrenci soyadı boş bırakılamaz!")
    private String soyad;

    @NotBlank(message = "Öğrenci numarası boş bırakılamaz!")
    @Column(name = "ogrenci_no", unique = true) // Aynı numara iki kez girilemesin
    private String studentNo;
}
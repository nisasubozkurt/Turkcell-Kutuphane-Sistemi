package turkcell.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "odunc_alma")
@Getter @Setter 
@NoArgsConstructor 
@AllArgsConstructor
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ogrenci_id") // Veritabanındaki kolon ismiyle aynı olmalı
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kitap_id") // Veritabanındaki kolon ismiyle aynı olmalı
    private Book book;

    private LocalDate verilisTarihi;
    private LocalDate teslimTarihi;
}
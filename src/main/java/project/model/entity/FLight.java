package project.model.entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "Flight")
public class FLight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,name = "origin")
    private String origin;

    @Column(nullable = false,name="destination")
    private String destination;

    @Column(nullable = false,name = "aviableSeats")
    private int aviableSeats;
    @Timestamp
    @Column(nullable = false , name = "timestamp")
    private LocalDateTime timestamp;


}

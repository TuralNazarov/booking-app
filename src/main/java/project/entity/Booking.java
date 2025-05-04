package project.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private FLight flight;

    @OneToOne
    @JoinColumn(name = "pasangers_id", nullable = false)
    private Pasangers pasangers;

    @Column(name = "numberOfSeats", nullable = false)
    private int numberOfSeats;
}

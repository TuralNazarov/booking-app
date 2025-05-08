package project.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingDto {
    private Long id;
    private Long flightId;
    private String passengerName;
    private Integer numberOfSeats;
}

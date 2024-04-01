package mapper;

import dto.FlightDetailsDTO;
import model.FlightDetails;
import org.springframework.stereotype.Component;

@Component
public class FlightDetailsMapper {
    public FlightDetails toEntity(FlightDetailsDTO dto) {
        FlightDetails entity = new FlightDetails();
        entity.setOperatorId(dto.getOperatorId());
        entity.setFlightId(dto.getFlightId());
        entity.setDeparture(dto.getDeparture());
        entity.setArrival(dto.getArrival());
        entity.setOrigin(dto.getOrigin());
        entity.setDestination(dto.getDestination());
        return entity;
    }

    public FlightDetailsDTO toDTO(FlightDetails entity) {
        FlightDetailsDTO dto = new FlightDetailsDTO();
        dto.setOperatorId(entity.getOperatorId());
        dto.setFlightId(entity.getFlightId());
        dto.setDeparture(entity.getDeparture());
        dto.setArrival(entity.getArrival());
        dto.setOrigin(entity.getOrigin());
        dto.setDestination(entity.getDestination());
        return dto;
    }
}

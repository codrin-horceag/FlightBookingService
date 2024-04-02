package main.mapper;

import main.dto.PaymentDetailsDTO;
import main.model.PaymentDetails;
import org.springframework.stereotype.Component;

@Component
public class PaymentDetailsMapper {
    public PaymentDetails toEntity(PaymentDetailsDTO dto) {
        PaymentDetails entity = new PaymentDetails();
        entity.setIban(dto.getIban());
        entity.setAmount(dto.getAmount());
        entity.setCurrency(dto.getCurrency());
        entity.setStatus(dto.getStatus());
        return entity;
    }

    public PaymentDetailsDTO toDTO(PaymentDetails entity) {
        PaymentDetailsDTO dto = new PaymentDetailsDTO();
        dto.setIban(entity.getIban());
        dto.setAmount(entity.getAmount());
        dto.setCurrency(entity.getCurrency());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}

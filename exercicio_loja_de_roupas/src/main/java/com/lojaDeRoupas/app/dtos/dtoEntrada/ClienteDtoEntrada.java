package com.lojaDeRoupas.app.dtos.dtoEntrada;

import com.lojaDeRoupas.app.config.messageHandling.errorMessages.ValidationErrorMessages;
import com.lojaDeRoupas.app.coreClasses.genericCrudSuperClasses.CrudGenericDTOIn;
import com.lojaDeRoupas.app.entities.VendaEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDtoEntrada extends CrudGenericDTOIn {
    @NotNull(message = ValidationErrorMessages.NOT_NULL)
    @Size(max = 100, message = ValidationErrorMessages.MAX_100)
    @NotBlank(message = ValidationErrorMessages.NOT_BLANK)
    private String nome;
    @CPF(message = ValidationErrorMessages.INVALID_CPF)
    @NotNull(message = ValidationErrorMessages.NOT_NULL)
    @Size(max = 15, message = ValidationErrorMessages.MAX_15)
    @NotBlank(message = ValidationErrorMessages.NOT_BLANK)
    private String cpf;
    @NotNull(message = ValidationErrorMessages.NOT_NULL)
    @Positive(message = ValidationErrorMessages.POSITIVE)
    private Long idade;
    @NotNull(message = ValidationErrorMessages.NOT_NULL)
    @Size(max = 15, message = ValidationErrorMessages.MAX_15)
    @NotBlank(message = ValidationErrorMessages.NOT_BLANK)
    private String telefone;
    private List<VendaEntity> vendas;
}

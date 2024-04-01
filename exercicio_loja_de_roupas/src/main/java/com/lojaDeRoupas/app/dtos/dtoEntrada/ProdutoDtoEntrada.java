package com.lojaDeRoupas.app.dtos.dtoEntrada;

import com.lojaDeRoupas.app.config.messageHandling.errorMessages.ValidationErrorMessages;
import com.lojaDeRoupas.app.coreClasses.genericCrudSuperClasses.CrudGenericDTOIn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDtoEntrada extends CrudGenericDTOIn {
    @Size(max = 255, message = ValidationErrorMessages.MAX_250)
    @NotNull(message = ValidationErrorMessages.NOT_NULL)
    @NotBlank(message = ValidationErrorMessages.NOT_BLANK)
    private String nome;

    @NotNull(message = ValidationErrorMessages.NOT_NULL)
    @Positive(message = ValidationErrorMessages.POSITIVE)
    private BigDecimal valor;
}

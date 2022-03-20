package sn.acodewriter.stockmanagement.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.acodewriter.stockmanagement.exception.ErrorCodes;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {

    private Integer httpCode;
    private ErrorCodes errorCode;
    private String message;
    private List<String> errors = new ArrayList<>();

}

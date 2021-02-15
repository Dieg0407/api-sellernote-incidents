package pe.external.sellercenter.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncidenceNoteDTO {
    @ApiModelProperty(required = true, notes = "Format [yyyy-MM-dd'T'HH:mm:ss]")
    @NotNull(message = "Field 'date' can't be null")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime date;

    @ApiModelProperty(required = true)
    @NotBlank(message = "Field 'text' can't be null or empty")
    private String text;

    private AuthorDTO author;
}

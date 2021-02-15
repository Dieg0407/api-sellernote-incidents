package pe.external.sellercenter.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncidenceDTO {
    @ApiModelProperty(required = true)
    @NotNull(message = "Field 'id' can't be null")
    private Long id;

    @ApiModelProperty(required = true, notes = "Format [yyyy-MM-dd'T'HH:mm:ss]")
    @NotNull(message = "Field 'date' can't be null")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime date;

    @ApiModelProperty(required = true)
    @NotBlank(message = "Field 'text' can't be null or empty")
    private String text;

    private Boolean active;

    @ApiModelProperty(required = true, notes = "Size can't exceed 10 characters")
    @Size(max = 10, message = "Field 'type' can't exceed 10 characters")
    private String type;

    @Valid
    private List<IncidenceNoteDTO> comments = new ArrayList<>();

    @ApiModelProperty(required = true, notes = "Size can't exceed 30 characters")
    @Size(max = 30, message = "Field 'orderId' can't exceed 30 characters")
    @NotBlank(message = "Field 'orderId' can't be null or empty")
    private String orderId;

    @ApiModelProperty(required = true, notes = "Size can't exceed 30 characters")
    @Size(max = 30, message = "Field 'type' can't exceed 30 characters")
    @NotBlank(message = "Field 'accountName' can't be null or empty")
    private String accountName;

    private AuthorDTO author;
}

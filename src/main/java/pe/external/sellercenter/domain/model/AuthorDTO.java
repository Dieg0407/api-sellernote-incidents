package pe.external.sellercenter.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorDTO {
    @ApiModelProperty(notes = "Size can't exceed 100 characters")
    @Size(max = 100, message = "Field 'id' can't exceed 30 characters")
    private String id;

    @ApiModelProperty(notes = "Size can't exceed 100 characters")
    @Size(max = 100, message = "Field 'firstName' can't exceed 30 characters")
    private String firstName;

    @ApiModelProperty(notes = "Size can't exceed 100 characters")
    @Size(max = 100, message = "Field 'lastName' can't exceed 30 characters")
    private String lastName;

    @ApiModelProperty(notes = "Size can't exceed 100 characters")
    @Size(max = 100, message = "Field 'email' can't exceed 30 characters")
    private String email;
}

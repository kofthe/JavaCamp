package Kodlama.io.Devs.business.requests.framework;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFrameworkRequest {

    private String createFrameworkName;
    private int pLanguageId;
}

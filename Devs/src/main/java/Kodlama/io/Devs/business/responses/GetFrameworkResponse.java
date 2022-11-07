package Kodlama.io.Devs.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetFrameworkResponse {

    private int id;
    private String frameworkName;
    private String pLanguageName;
    private int frameworkId;
}

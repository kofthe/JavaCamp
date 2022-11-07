package Kodlama.io.Devs.business.requests.framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFrameworkRequest {

    private int id;
    private String name;
    private int progId;
}

package Kodlama.io.Devs.business.abstracts;

import Kodlama.io.Devs.business.requests.framework.CreateFrameworkRequest;
import Kodlama.io.Devs.business.requests.framework.DeleteFrameworkRequest;
import Kodlama.io.Devs.business.requests.framework.UpdateFrameworkRequest;
import Kodlama.io.Devs.business.responses.GetFrameworkResponse;
import org.hibernate.sql.Delete;
import org.springframework.stereotype.Service;

import java.util.List;


public interface FrameworkService {

    List<GetFrameworkResponse> getAll();

    void addFramework(CreateFrameworkRequest createFrameworkRequest) throws Exception;

    void deleteFramework(DeleteFrameworkRequest deleteFrameworkRequest) throws Exception;


    void updateFramework(UpdateFrameworkRequest updateFrameworkRequest) throws Exception;

}

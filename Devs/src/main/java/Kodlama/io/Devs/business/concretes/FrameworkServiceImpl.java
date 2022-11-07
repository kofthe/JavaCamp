package Kodlama.io.Devs.business.concretes;

import Kodlama.io.Devs.business.abstracts.FrameworkService;
import Kodlama.io.Devs.business.requests.framework.CreateFrameworkRequest;
import Kodlama.io.Devs.business.requests.framework.DeleteFrameworkRequest;
import Kodlama.io.Devs.business.requests.framework.UpdateFrameworkRequest;
import Kodlama.io.Devs.business.responses.GetFrameworkResponse;
import Kodlama.io.Devs.core.CheckService;
import Kodlama.io.Devs.entities.concretes.Framework;
import Kodlama.io.Devs.entities.concretes.PLanguage;
import Kodlama.io.Devs.repository.abstracts.FrameworkRepository;
import Kodlama.io.Devs.repository.abstracts.PLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FrameworkServiceImpl implements FrameworkService {

    PLanguageRepository pLanguageRepository;
    FrameworkRepository frameworkRepository;
    CheckService checkService;

    @Autowired
    public FrameworkServiceImpl(PLanguageRepository pLanguageRepository, FrameworkRepository frameworkRepository) {
        this.pLanguageRepository = pLanguageRepository;
        this.frameworkRepository = frameworkRepository;

    }

    @Override
    public List<GetFrameworkResponse> getAll() {
        List<Framework> frameworkList = frameworkRepository.findAll();
        List<GetFrameworkResponse> getFrameworkResponseList = new ArrayList<>();
        for(Framework framework : frameworkList ) {
            GetFrameworkResponse getFrameworkResponse = new GetFrameworkResponse();
            getFrameworkResponse.setFrameworkName(framework.getFrameworkName());
            getFrameworkResponse.setPLanguageName(framework.getPLanguage().getProgName());
            getFrameworkResponseList.add(getFrameworkResponse);
        }

        return getFrameworkResponseList;
    }

    @Override
    public void addFramework(CreateFrameworkRequest createFrameworkRequest) throws Exception {
        if (isNameExist(createFrameworkRequest.getCreateFrameworkName()) || createFrameworkRequest.getCreateFrameworkName().isBlank() ) {
            throw new Exception("İd mevcut. Eklenememektedir.");
        }

        Framework framework = new Framework();
        PLanguage pLanguage = pLanguageRepository.findById(createFrameworkRequest.getPLanguageId()).get();
        framework.setFrameworkName(createFrameworkRequest.getCreateFrameworkName());
        framework.setPLanguage(pLanguage);
        frameworkRepository.save(framework);
    }

    @Override
    public void deleteFramework(DeleteFrameworkRequest deleteFrameworkRequest) throws Exception {
        if (isIdExist(deleteFrameworkRequest.getId())) {
            throw new Exception("Silinecek id yok.");
        }

        Framework framework = new Framework();
        framework.setId(deleteFrameworkRequest.getId());
        frameworkRepository.delete(framework);
    }


    @Override
    public void updateFramework(UpdateFrameworkRequest updateFrameworkRequest) throws Exception {
        if (isNameExist(updateFrameworkRequest.getName()) || isIdNotExist(updateFrameworkRequest.getId())){
            throw new Exception("Güncellenemez.");
        }

        Framework framework = new Framework();
        PLanguage pLanguage = pLanguageRepository.findById(updateFrameworkRequest.getProgId()).get();
        framework.setFrameworkName(updateFrameworkRequest.getName());
        framework.setId(updateFrameworkRequest.getId());
        framework.setPLanguage(pLanguage);
        frameworkRepository.save(framework);
    }

    private boolean isNameExist(String name) {
        for (Framework framework1 : frameworkRepository.findAll()) {
            if (framework1.getFrameworkName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private boolean isIdExist(int id) {
        for (Framework framework1 : frameworkRepository.findAll()) {
            if (framework1.getId() == id){
                return true;
            }
        }
        return false;
    }

    private boolean isIdNotExist(int id) {
        for (Framework framework1 : frameworkRepository.findAll()) {
            if (framework1.getId() == id){
                return false;
            }
        }
        return true;
    }

}

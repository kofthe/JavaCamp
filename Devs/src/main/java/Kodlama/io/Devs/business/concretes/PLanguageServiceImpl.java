package Kodlama.io.Devs.business.concretes;


import Kodlama.io.Devs.business.abstracts.PLanguageService;
import Kodlama.io.Devs.business.requests.pLanguage.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.pLanguage.RemoveLanguageRequest;
import Kodlama.io.Devs.business.requests.pLanguage.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.GetProgrammingLanguageResponse;
import Kodlama.io.Devs.core.CheckService;
import Kodlama.io.Devs.entities.concretes.PLanguage;
import Kodlama.io.Devs.repository.abstracts.PLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PLanguageServiceImpl implements PLanguageService {

    private PLanguageRepository pLanguageRepository;

    @Autowired
    public PLanguageServiceImpl(PLanguageRepository pLanguageRepository) {
        this.pLanguageRepository = pLanguageRepository;
    }

    @Override
    public List<GetProgrammingLanguageResponse> getAllPLanguages() {
        List<PLanguage> pLanguages = this.pLanguageRepository.findAll();
        List<GetProgrammingLanguageResponse> getProgrammingLanguageResponse = new ArrayList<>();
        for(PLanguage pLanguage : pLanguages){
            GetProgrammingLanguageResponse responseItem = new GetProgrammingLanguageResponse();
            responseItem.setId(pLanguage.getProgId());
            responseItem.setProgName(pLanguage.getProgName());
            getProgrammingLanguageResponse.add(responseItem);
        }
        return getProgrammingLanguageResponse;
    }

    @Override
    public GetProgrammingLanguageResponse getById(int id) {
        PLanguage pLanguage = pLanguageRepository.findById(id).get();
        GetProgrammingLanguageResponse getProgrammingLanguageResponse = new GetProgrammingLanguageResponse();
        getProgrammingLanguageResponse.setId(pLanguage.getProgId());
        getProgrammingLanguageResponse.setProgName(pLanguage.getProgName());
        return getProgrammingLanguageResponse;
    }

    @Override
    public void addPLanguage(CreateLanguageRequest createLanguageRequest) throws Exception {
        if (createLanguageRequest.getCreateLanguageRequest().isBlank() || isNameExist(createLanguageRequest.getCreateLanguageRequest())) {
            throw new Exception("Koşullar Sağlanmadı");
        }
       PLanguage pLanguage = new PLanguage();
       pLanguage.setProgName(createLanguageRequest.getCreateLanguageRequest());
       pLanguageRepository.save(pLanguage);
    }

    @Override
    public void removePLanguage(RemoveLanguageRequest removeLanguageRequest) throws Exception {
        if(isIdExist(removeLanguageRequest.getId())) {
            throw new Exception("Silinceke ID bulunamadı");
        }
        PLanguage pLanguage = new PLanguage();
        pLanguage.setProgId(removeLanguageRequest.getId());
        pLanguageRepository.delete(pLanguage);
    }

    @Override
    public void updatePLanguage(UpdateLanguageRequest updateLanguageRequest) throws Exception {

        if (isNameExist(updateLanguageRequest.getUpdateLanguageRequest()) || isIdNotExist(updateLanguageRequest.getId())) {
            throw new Exception("Eksik var. Eksikleri kontrol edip tekrar deneyiniz.");
        }
        PLanguage pLanguage = new PLanguage();
        pLanguage.setProgName(updateLanguageRequest.getUpdateLanguageRequest());
        pLanguage.setProgId(updateLanguageRequest.getId());
        pLanguageRepository.save(pLanguage);
    }

    private boolean isIdExist(int id) {
        for (PLanguage pLanguage1 : pLanguageRepository.findAll()) {
            if (pLanguage1.getProgId() == id) {
                return true;
            }
        }
        return false;
    }

    private boolean isNameExist(String name) {
        for(PLanguage pLanguage1 : pLanguageRepository.findAll()) {
            if (pLanguage1.getProgName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private boolean isIdNotExist(int id) {
        for (PLanguage pLanguage : pLanguageRepository.findAll()) {
            if(pLanguage.getProgId() == id) {
                return false;
            }
        }
        return true;
    }

}

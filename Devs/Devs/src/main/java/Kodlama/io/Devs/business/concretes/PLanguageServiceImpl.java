package Kodlama.io.Devs.business.concretes;


import Kodlama.io.Devs.business.abstracts.PLanguageService;
import Kodlama.io.Devs.entities.concretes.PLanguage;
import Kodlama.io.Devs.repository.abstracts.PLanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PLanguageServiceImpl implements PLanguageService {

    PLanguageRepository pLanguageRepository;

    @Autowired
    public PLanguageServiceImpl(PLanguageRepository pLanguageRepository) {
        this.pLanguageRepository = pLanguageRepository;
    }

    @Override
    public List<PLanguage> getAllPLanguages() {
        return pLanguageRepository.findAll();
    }

    @Override
    public PLanguage getpLanguage(int progId) {
        return pLanguageRepository.findById(progId).get();
    }

    @Override
    public void addPLanguage(PLanguage pLanguage) throws Exception {
        List<PLanguage> pLanguages = pLanguageRepository.findAll();
        for (PLanguage pLanguage1 : pLanguages) {
            if(pLanguage1.getProgName().equals(pLanguage.getProgName())) {
                throw new Exception(pLanguage.getProgName() + "Zaten kayıtlı.");
            }

        }
        if(pLanguage.getProgName() == null) {
            throw new Exception("Dil ismi boş olamaz.");
        }
        pLanguageRepository.save(pLanguage);
    }

    @Override
    public void removePLanguage(int progId) {
        pLanguageRepository.deleteById(progId);
    }

    @Override
    public void updatePLanguage(PLanguage pLanguage) {
        pLanguageRepository.save(pLanguage);
    }
}

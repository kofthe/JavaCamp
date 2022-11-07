package Kodlama.io.Devs.business.abstracts;


import Kodlama.io.Devs.business.requests.pLanguage.CreateLanguageRequest;
import Kodlama.io.Devs.business.requests.pLanguage.RemoveLanguageRequest;
import Kodlama.io.Devs.business.requests.pLanguage.UpdateLanguageRequest;
import Kodlama.io.Devs.business.responses.GetProgrammingLanguageResponse;
import Kodlama.io.Devs.entities.concretes.PLanguage;

import java.util.List;

public interface PLanguageService {

    List<GetProgrammingLanguageResponse> getAllPLanguages();

    public GetProgrammingLanguageResponse getById(int progId) ;


    void removePLanguage(RemoveLanguageRequest removeLanguageRequest) throws Exception;


    void addPLanguage(CreateLanguageRequest createLanguageRequest) throws Exception;

    void updatePLanguage(UpdateLanguageRequest updateLanguageRequest) throws Exception;

    }

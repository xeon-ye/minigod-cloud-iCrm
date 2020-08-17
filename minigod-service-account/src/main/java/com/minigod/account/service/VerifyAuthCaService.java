package com.minigod.account.service;

import com.minigod.protocol.account.model.VerifyAuthCa;

import java.util.List;

public interface VerifyAuthCaService {
    public void saveOrUpdateCaAuth(VerifyAuthCa verifyAuthCa);

    public VerifyAuthCa getValidAuthCa(String idCard);

    public VerifyAuthCa getValidAuthCaById(Integer id);

    public List<VerifyAuthCa> getErrorVerifyAuthCa(String idCard);

    public void clearErrorVerifyCa(String idCard);

}

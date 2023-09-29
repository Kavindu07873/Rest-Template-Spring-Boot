package com.partyApi.rdPartyApi.service;

import com.partyApi.rdPartyApi.dto.formdataDTO;

import java.util.List;
import java.util.Map;

public interface apiService {
    Map<String,Object> getPosts(formdataDTO dto);

}

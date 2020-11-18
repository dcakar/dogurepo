package com.vodafone.zeus.application.web.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vodafone.zeus.application.common.ApplicationConstants;
import com.vodafone.zeus.application.dto.ConvertedDataDTO;
import com.vodafone.zeus.application.dto.ResultDTO;
import com.vodafone.zeus.application.service.DataConverterService;
import com.vodafone.zeus.application.web.response.ConvertedDataResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "Vodafone Zeus API")
@RestController
@RequestMapping("/zeus")
public class ZeusController {
    private DataConverterService dataConverterService;

    @ApiOperation(value = "Converts data")
    @GetMapping(path = "/convert")
    public ResponseEntity<ConvertedDataResponse> convertData() throws Exception {
        ConvertedDataResponse response = new ConvertedDataResponse();
        ResultDTO result = new ResultDTO();
        List<ConvertedDataDTO> convertedDataList = new ArrayList<>();
        convertedDataList.add(dataConverterService.convertData());
        result.setConvertedDataList(convertedDataList);
        response.setResult(result);
        response.setMessage(ApplicationConstants.SUCCESS);
        response.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

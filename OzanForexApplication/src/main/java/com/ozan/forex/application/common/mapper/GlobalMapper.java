package com.ozan.forex.application.common.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ozan.forex.application.dao.entity.Conversion;
import com.ozan.forex.application.dto.ConversionDTO;

public final class GlobalMapper {
	public static Conversion toConversionEntity(ConversionDTO conversionDTO) {
		if (conversionDTO == null) {
			return null;
		}
		Conversion conversion = new Conversion();
		conversion.setConversionAmount(conversionDTO.getConversionAmount());
		conversion.setSourceAmount(conversionDTO.getSourceAmount());
		conversion.setSourceCurrency(conversionDTO.getSourceCurrency());
		conversion.setTargetCurrency(conversionDTO.getTargetCurrency());
		conversion.setTransactionDate(conversionDTO.getTransactionDate());
		conversion.setTransactionId(conversionDTO.getTransactionId());
		return conversion;
	}

	public static ConversionDTO toConversionDTO(Conversion conversion) {
		if (conversion == null) {
			return null;
		}
		ConversionDTO conversionDTO = new ConversionDTO();
		conversionDTO.setConversionAmount(conversion.getConversionAmount());
		conversionDTO.setSourceAmount(conversion.getSourceAmount());
		conversionDTO.setSourceCurrency(conversion.getSourceCurrency());
		conversionDTO.setTargetCurrency(conversion.getTargetCurrency());
		conversionDTO.setTransactionDate(conversion.getTransactionDate());
		conversionDTO.setTransactionId(conversion.getTransactionId());
		return conversionDTO;
	}

	public static List<Conversion> toConversionList(List<ConversionDTO> conversionDTOList) {
		if (conversionDTOList == null) {
			return null;
		}
		List<Conversion> conversionList = new ArrayList<>();
		conversionDTOList.forEach(element -> conversionList.add(toConversionEntity(element)));
		return conversionList;
	}

	public static List<ConversionDTO> toConversionDTOList(List<Conversion> conversionList) {
		if (conversionList == null) {
			return null;
		}
		List<ConversionDTO> conversionDTOList = new ArrayList<>();
		conversionList.forEach(element -> conversionDTOList.add(toConversionDTO(element)));
		return conversionDTOList;
	}
}

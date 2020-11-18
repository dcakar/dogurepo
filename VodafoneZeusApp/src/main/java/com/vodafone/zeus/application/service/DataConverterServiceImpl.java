package com.vodafone.zeus.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vodafone.zeus.application.common.ApplicationConstants;
import com.vodafone.zeus.application.dto.ConvertedDataDTO;
import com.vodafone.zeus.application.model.BillingAccount;
import com.vodafone.zeus.application.model.ContactPerson;
import com.vodafone.zeus.application.model.ContactPoint;
import com.vodafone.zeus.application.model.CustomerAccount;
import com.vodafone.zeus.application.model.CustomerAccountModel;
import com.vodafone.zeus.application.model.CustomerInformationModel;
import com.vodafone.zeus.application.model.Parts;
import com.vodafone.zeus.application.model.RelatedCustomerAccount;
import com.vodafone.zeus.application.model.ServiceAccount;
import com.vodafone.zeus.application.util.StringUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class DataConverterServiceImpl implements DataConverterService {
    

    @Override
    public ConvertedDataDTO convertData() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        CustomerInformationModel customerInformationModel = restTemplate.getForObject(ApplicationConstants.DESTINATION_URL, CustomerInformationModel.class);
        ConvertedDataDTO convertedDataDTO = new ConvertedDataDTO();
        if (customerInformationModel != null) {
            CustomerAccountModel customerAccountModel = customerInformationModel.getCustomerInformation().getBody().getResponse().getCustomerAccountModel();
            RelatedCustomerAccount relatedCustomerAccount = customerAccountModel.getCustomerAccountList().get(0).getRelatedCustomerAccounts().getRelatedCustomerAccountList().get(0);
            CustomerAccount customerAccount = customerAccountModel.getCustomerAccountList().get(0);
            ContactPerson contactPerson = customerAccountModel.getCustomerAccountList().get(0).getParts().getContactPeople().getContactPerson().get(0);
            ContactPoint contactPoint = contactPerson.getContactPoints().getContactPoint().get(0);
            Parts parts = customerAccountModel.getCustomerAccountList().get(0).getParts();
            ServiceAccount serviceAccountModel = parts.getServiceAccounts().getServiceAccount().get(0);
            BillingAccount billingAccountModel = parts.getBillingAccounts().getBillingAccount().get(0);
            convertedDataDTO.setSiebelCustomerId(customerAccountModel.getCustomerAccountList().get(0).getIdModel().getIdList().get(0));
            convertedDataDTO.setStatus(customerAccount.getStatus());
            convertedDataDTO.setCreated(customerAccount.getCreated());
            convertedDataDTO.setPin(customerAccount.getDetails().getPin());
            convertedDataDTO.setFatherName(StringUtil.toCamelCase(relatedCustomerAccount.getName()));
            String camelCase = StringUtil.toCamelCase(relatedCustomerAccount.getDesc());
            convertedDataDTO.setMotherMaidenName(StringUtil.maskWithChar(camelCase, ApplicationConstants.CHAR_STAR, 2));
            convertedDataDTO.setTckn(contactPerson.getIdModel().getIdList().get(0).replaceAll(ApplicationConstants.STRING_X, ApplicationConstants.STRING_STAR));
            convertedDataDTO.setTcknUnmasked(contactPerson.getIdModel().getIdList().get(0));
            convertedDataDTO.setFirstName(StringUtil.toCamelCase(contactPerson.getIndividualName().getFirstName()));
            convertedDataDTO.setFamilyName(StringUtil.toCamelCase(contactPerson.getIndividualName().getFamilyName()));
            convertedDataDTO.setBirthDate(contactPerson.getBirthDate().getDateString());
            convertedDataDTO.setCustomerType(contactPerson.getType());
            convertedDataDTO.setAddress(StringUtil.toCamelCase(contactPoint.getPostal().getStreet())); 
            convertedDataDTO.setFullNumber(contactPoint.getTelephone() != null ? contactPoint.getTelephone().getFullNumber() : null);
            convertedDataDTO.setIccid(serviceAccountModel.getIdModel().getIdList().get(0));
            convertedDataDTO.setBillTypeCode(billingAccountModel.getBillTypeCode());
        }
        return convertedDataDTO;
    }
}

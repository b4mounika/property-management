package com.example.demo.service.impl;

import com.example.demo.converter.PropertyConverter;
import com.example.demo.dto.PropertyDTO;
import com.example.demo.entity.PropertyEntity;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.PropertyService;
import com.sun.xml.bind.v2.runtime.property.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity pe =   propertyConverter.convertDTOtoEntity(propertyDTO);
       pe = propertyRepository.save(pe);
    propertyDTO = propertyConverter.convertEntityToDTO(pe);

        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
       List<PropertyEntity> listOfProps = (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> propList = new ArrayList<>();

        for(PropertyEntity pe : listOfProps){
          PropertyDTO dto = propertyConverter.convertEntityToDTO(pe);
           propList.add(dto);
       }
        return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {

       Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
       PropertyDTO dto = null;

       if(optEn.isPresent()){

           PropertyEntity pe =optEn.get();//data from database
           pe.setTitle(propertyDTO.getTitle());
           pe.setAddress(propertyDTO.getAddress());
           pe.setPrice(propertyDTO.getPrice());
           pe.setDescription(propertyDTO.getDescription());
           dto = propertyConverter.convertEntityToDTO(pe);
           propertyRepository.save(pe);
       }
        return null;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()){
            PropertyEntity pe =optEn.get();//data from database
            pe.setDescription(propertyDTO.getDescription());
            dto = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()){
            PropertyEntity pe =optEn.get();//data from database
            pe.setPrice(propertyDTO.getPrice());
            dto = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {

        propertyRepository.deleteById(propertyId);
    }

}

package com.example.xsis.business.shared_domain.util;

import com.example.xsis.business.shared_domain.constant.GlobalConstant;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface TimeConverter {

    @Named("localDateTimetoString")
    default String localDateTimetoString(LocalDateTime dateTime){
        if (dateTime != null) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(GlobalConstant.FORMAT_TIMESTAMP);
                String formatedDateTime = dateTime.format(formatter);
                return formatedDateTime;
            }catch (Exception e){
                return dateTime.toString();
            }
        }
        return null;
    }

    @Named("stringToLocalDateTime")
    default LocalDateTime stringToLocalDateTime(String formatedString){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(GlobalConstant.FORMAT_TIMESTAMP);
            LocalDateTime dateTime = LocalDateTime.parse(formatedString, formatter);
            return dateTime;
        }catch (Exception e){
            return LocalDateTime.now();
        }
    }
}

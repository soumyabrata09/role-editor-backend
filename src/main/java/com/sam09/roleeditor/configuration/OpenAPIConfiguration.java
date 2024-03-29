package com.sam09.roleeditor.configuration;

import com.sam09.roleeditor.utils.ApplicationConstants;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = ApplicationConstants.TITLE,
                description = ApplicationConstants.DESCRIPTION,
                termsOfService = ApplicationConstants.TERMS,
                version = ApplicationConstants.VERSION,
                contact = @Contact(
                        name = "V3nom09_Sentinel",
                        email = "sen.soumyabrata09@yahoo.com"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://choosealicense.com/licenses/mit/"
                )
        )
)
public class OpenAPIConfiguration {

}

package org.jt.studentManagementSystem.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "contacts")
public record ContactInformation(String message,
                                 Map<String, String> details,
                                 List<String> contactNumber
) {
}

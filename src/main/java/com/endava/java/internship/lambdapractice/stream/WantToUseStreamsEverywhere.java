package com.endava.java.internship.lambdapractice.stream;

import com.google.common.collect.ImmutableMap;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

public class WantToUseStreamsEverywhere {

    //do not over engineer
    class UseStreamToBuildMap {
        public Map<String, Object> getJpaProperties() {
            return Stream.of(
                    new AbstractMap.SimpleEntry<>("hibernate.show_sql", "true"),
                    new AbstractMap.SimpleEntry<>("hibernate.format_sql", "true")
            ).collect(collectingAndThen(
                toMap(Map.Entry::getKey, Map.Entry::getValue),
                Collections::unmodifiableMap)
            );
        }
    }

    //be as simple as possible
    class UseOldPlainMap {
        public Map<String, Object> getJpaProperties() {
            Map<String, Object> properties = new HashMap<>();
            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.format_sql", "true");
            return Collections.unmodifiableMap(properties);
        }

        public Map<String, Object> getJpaPropertiesAnotherWay() {
            return ImmutableMap.<String, Object>builder()
                .put("hibernate.show_sql", "true")
                .put("hibernate.format_sql", "true")
                .build();
        }
    }
}

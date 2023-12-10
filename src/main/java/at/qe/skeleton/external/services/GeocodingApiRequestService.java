package at.qe.skeleton.external.services;

import at.qe.skeleton.external.model.geocoding.GeocodingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Service class for making requests to the geocoding API from "openweathermap" to retrieve information about locations.
 * We use the values of longitude and latitude for further API calls.
 */
@Scope("application")
@Component
@Validated
public class GeocodingApiRequestService {

    private static final String GEOCODING_URI = "/geo/1.0/direct";
    private static final String CITY_PARAMETER = "q";
    private static final String LIMIT_PARAMETER = "limit";

    @Autowired
    private RestClient restClient;

    /**
     * Retrieves geocoding information for a given city from the geocoding API.
     *
     * @param city The name of the city (and optional additional information separated by commas).
     * @return A list of GeocodingDTO objects representing the geocoding information for the specified city.
     */
    public List<GeocodingDTO> retrieveGeocodingData(String city) {
        String encodedCity = encodeCity(city);
        ResponseEntity<List<GeocodingDTO>> responseEntity = this.restClient.get()
                .uri(UriComponentsBuilder.fromPath(GEOCODING_URI)
                        .queryParam(CITY_PARAMETER, encodedCity)
                        .queryParam(LIMIT_PARAMETER, 1)
                        .build().toUriString())
                .retrieve()
                .toEntity(new ParameterizedTypeReference<List<GeocodingDTO>>() {});

        // todo: introduce error handling using responseEntity.getStatusCode.isXXXError
        return responseEntity.getBody();
    }

    /**
     * Encodes the city part of a given string by trimming after the first comma and URL encoding it.
     *
     * @param city The original city string (and optional additional information separated by commas).
     * @return The trimmed and URL-encoded city string.
     */
    private String encodeCity(String city){
        String[] parts = city.split(",");
        String trimmedCity = parts[0];
        return URLEncoder.encode(trimmedCity, StandardCharsets.UTF_8);
    }
}

package pt.uc.dei.paj.providers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * This class is a ObjectMapper to provide JSON (JAXB/POJO) using Jackson.
 * See documentation:
 * https://eclipse-ee4j.github.io/jersey.github.io/documentation/latest/media.html
 * (in particular, Example 9.14. ContextResolver<ObjectMapper>)
 * https://www.baeldung.com/jackson-object-mapper-tutorial
 * <p>
 * This class configures the ObjectMapper to handle serialization of Java 8 date types.
 */
@Provider
public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {

    final ObjectMapper defaultObjectMapper;

    public ObjectMapperProvider() {
        defaultObjectMapper = createDefaultMapper();
    }

    private static ObjectMapper createDefaultMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper;
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return defaultObjectMapper;
    }
}
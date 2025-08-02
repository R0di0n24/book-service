package telran.java58.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import telran.java58.book.dto.BookDto;
import telran.java58.book.model.Book;

@Configuration
public class ServiceConfiguration {

    @Bean
    ModelMapper getModelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        mapper.createTypeMap(Book.class, BookDto.class)
                .addMappings(m -> m.map(src -> src.getPublisher().getPublisherName(),
                        BookDto::setPublisher));

        return mapper;
    }
}

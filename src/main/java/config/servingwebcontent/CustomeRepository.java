package config.servingwebcontent;

import config.servingwebcontent.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomeRepository extends MongoRepository<Customer, String> {
}

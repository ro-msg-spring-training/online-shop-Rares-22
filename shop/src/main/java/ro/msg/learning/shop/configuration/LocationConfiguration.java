package ro.msg.learning.shop.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.shop.exception.StrategyException;
import ro.msg.learning.shop.strategy.ILocationStrategy;
import ro.msg.learning.shop.strategy.MostAbundant;
import ro.msg.learning.shop.strategy.SingleLocation;

@Configuration
public class LocationConfiguration {

    @Bean
    public ILocationStrategy createOrderStrategy(@Value("${strategy}") String strategy, MostAbundant mostAbundant, SingleLocation singleLocation) {
        switch (strategy) {
            case "SingleLocation":
                return singleLocation;
            case "MostAbundant":
                return mostAbundant;
            default:
                throw new StrategyException("Select a valid strategy!");
        }
    }
}

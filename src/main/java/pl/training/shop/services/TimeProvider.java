package pl.training.shop.services;

import java.time.Instant;

public interface TimeProvider {

    Instant getTimestamp();

}

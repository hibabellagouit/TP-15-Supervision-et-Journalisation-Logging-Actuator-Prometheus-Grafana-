package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import io.micrometer.core.instrument.Metrics;
@Service
public class DemoService {
    private static final Logger logger = LoggerFactory.getLogger(DemoService.class);

    public String processData() {
        Metrics.counter("custom.requests.count").increment();
        logger.info("Requête enregistrée dans Prometheus");
        return "Traitement terminé";
    }
}
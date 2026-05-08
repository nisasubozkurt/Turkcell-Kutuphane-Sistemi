package com.turkcell.kutuphane_cqrs.core.pipeline;

import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@Slf4j
@Component
public class PerformanceMonitoringBehavior implements IPipelineBehavior {
    @Override
    public <TResponse> TResponse handle(Object request, Supplier<TResponse> next) throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            return next.get();
        } finally {
            stopwatch.stop();
            long elapsed = stopwatch.elapsed(TimeUnit.MILLISECONDS);
            
            if (elapsed > 3000) {
                log.warn("⚠️ [PERFORMANS]: {} işlemi {}ms sürdü! (Sınır 3000ms)", 
                        request.getClass().getSimpleName(), elapsed);
            }
        }
    }
}

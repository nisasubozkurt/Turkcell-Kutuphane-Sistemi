package com.turkcell.kutuphane_cqrs.core.pipeline;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.function.Supplier;

@Slf4j
@Component
public class LoggingBehavior implements IPipelineBehavior {

    @Override
    public <TResponse> TResponse handle(Object request, Supplier<TResponse> next) throws Exception {
        String requestName = request.getClass().getSimpleName();
        
        // 1. İstek geldiğinde logla
        log.info("🚀 [LOG-İSTEK]: {} - Veri: {}", requestName, request);

        // 2. Bir sonraki aşamaya (varsa diğer behavior veya asıl Handler) geç
        TResponse response = next.get();

        // 3. Cevap döndüğünde logla
        log.info("✅ [LOG-CEVAP]: {} - Sonuç: {}", requestName, response);

        return response;
    }
}

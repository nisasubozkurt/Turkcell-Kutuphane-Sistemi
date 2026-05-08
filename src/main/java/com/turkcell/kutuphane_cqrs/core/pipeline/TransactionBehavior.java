package com.turkcell.kutuphane_cqrs.core.pipeline;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import java.util.function.Supplier;

@Slf4j
@Component
@Order(3) // Sıralama çok önemli!
public class TransactionBehavior implements IPipelineBehavior {

    private final PlatformTransactionManager transactionManager;

    public TransactionBehavior(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public <TResponse> TResponse handle(Object request, Supplier<TResponse> next) throws Exception {
        // Sadece Command'ler için transaction aç
        if (!request.getClass().getSimpleName().endsWith("Command")) {
            return next.get();
        }

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("CQRS-Transaction");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            log.info("⛓️ [TRANSACTION START]: {}", request.getClass().getSimpleName());
            TResponse response = next.get();
            transactionManager.commit(status);
            log.info("💾 [TRANSACTION COMMIT]: Veritabanına başarıyla yazıldı.");
            return response;
        } catch (Exception ex) {
            transactionManager.rollback(status);
            log.error("❌ [TRANSACTION ROLLBACK]: İşlem geri alındı! Hata: {}", ex.getMessage());
            throw ex;
        }
    }
}
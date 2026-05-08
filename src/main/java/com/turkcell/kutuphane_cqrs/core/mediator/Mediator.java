package com.turkcell.kutuphane_cqrs.core.mediator;

import com.turkcell.kutuphane_cqrs.core.pipeline.IPipelineBehavior;
import com.turkcell.kutuphane_cqrs.features.commands.CreateBookCommand;
import com.turkcell.kutuphane_cqrs.features.handlers.CreateBookCommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class Mediator {
    private final ApplicationContext context;
    private final List<IPipelineBehavior> behaviors;

    public <TRequest, TResponse> TResponse send(TRequest request) throws Exception {
        Supplier<TResponse> process = () -> {
            return invokeHandler(request);
        };

        // Zinciri oluştururken davranışları (behaviors) sırayla ekliyoruz
        for (IPipelineBehavior behavior : behaviors) {
            final Supplier<TResponse> next = process;
            process = () -> {
                try {
                    return behavior.handle(request, next);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            };
        }

        return process.get();
    }

    @SuppressWarnings("unchecked")
    private <TRequest, TResponse> TResponse invokeHandler(TRequest request) {
        if (request instanceof CreateBookCommand) {
            var handler = context.getBean(CreateBookCommandHandler.class);
            // Handler'dan dönen Book nesnesini TResponse olarak cast ediyoruz
            return (TResponse) handler.handle((CreateBookCommand) request);
        }
        return null;
    }
}

package com.turkcell.kutuphane_cqrs.core.pipeline;

import java.util.function.Supplier;

public interface IPipelineBehavior {
    <TResponse> TResponse handle(Object request, Supplier<TResponse> next) throws Exception;
}

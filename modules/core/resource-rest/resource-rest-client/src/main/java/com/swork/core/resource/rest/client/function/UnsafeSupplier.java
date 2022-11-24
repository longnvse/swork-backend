package com.swork.core.resource.rest.client.function;

import javax.annotation.Generated;

/**
 * @author Long Hip
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}
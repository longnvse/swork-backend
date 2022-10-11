package com.swork.checklist.rest.client.function;

import javax.annotation.Generated;

/**
 * @author adm
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}
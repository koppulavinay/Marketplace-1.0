package buycorp.specification.rest.api.client.function;

import javax.annotation.Generated;

/**
 * @author kashyap.mishra
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}
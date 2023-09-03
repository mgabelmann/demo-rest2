/**
 * <p>Contains simple Java objects which are used to transfer data between application layers. Typically, this is
 * between the service/facade layer and the controller layer.</p>
 * <p>Used to make interactions with one or more services easier when associations may not normally exist or the
 * underlying implementation needs to be abstracted or hidden.</p>
 * <p>These are also called POJOs or Java Beans, but they are not DTOs as they are not used to communicate across
 * a network boundary or between processes.</p>
 */
@NonNullFields
package ca.mikegabelmann.demo2.persistence.facade.bean;

import org.springframework.lang.NonNullFields;
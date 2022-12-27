/**
 * Interfaces and implementations for the service layer. All logic, validation, packaging and unpackaging of data from
 * database are controlled here. If there are errors, exceptions should be thrown so they can be handled at another
 * layer. Database entities (JPA) objects should not leave this layer as it exposes underlying architecture and dirties
 * the objects with unnecessary presentation and transport logic.
 *
 * @author mgabelmann
 */
package ca.mikegabelmann.demo2.persistence.service;

/* AggregatorExistsException.java - created on Oct 10, 2014, Copyright (c) 2011 The European Library, all rights reserved */
package pt.utl.ist.util.exceptions;

import java.io.Serializable;

/**
 * An entity of Aggregator exists already.
 * 
 * @author Simon Tzanakis (Simon.Tzanakis@theeuropeanlibrary.org)
 * @since Oct 10, 2014
 */
public class AggregatorExistsException extends Exception implements Serializable{
    private static final long serialVersionUID = 44L;

    public AggregatorExistsException() {
        super();
    }

    public AggregatorExistsException(String msg) {
        super(msg);
    }

    public AggregatorExistsException(String msg, Exception e) {
        super(msg, e);
    }
}
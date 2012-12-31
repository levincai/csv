/*
 * This file is part of CSV package.
 *
 *  CSV is free software: you can redistribute it 
 *  and/or modify it under the terms of version 3 of the GNU 
 *  Lesser General Public  License as published by the Free Software 
 *  Foundation.
 *  
 *  CSV is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public 
 *  License along with CSV.  If not, see 
 *  <http://www.gnu.org/licenses/lgpl-3.0.html>.
 */
package csv.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * An abstract implementation of TableReader.
 * This implementation takes care of simple stream handling.
 * @author RalphSchuster
 *
 */
public abstract class AbstractStreamTableReader extends AbstractTableReader {

	private InputStream inputStream;
	private BufferedReader reader;
	
	/**
	 * Default Constructor.
	 */
	public AbstractStreamTableReader() {
	}

	/**
	 * The constructor for a given input stream.
	 * @param in input stream
	 */
	public AbstractStreamTableReader(InputStream in) {
        setInputStream(in);
    }
	
    /** 
     * Creates a new instance of Reader.
     * @param file file to read from
     * @throws FileNotFoundException when the file could not be found.
     * 
     */
    public AbstractStreamTableReader(File file) throws FileNotFoundException {
        this(new FileInputStream(file));
    }
    
    /** 
     * Creates a new instance of Reader.
     * @param file file to read from
     * @throws FileNotFoundException when the file could not be found.
     * 
     */
    public AbstractStreamTableReader(String file) throws FileNotFoundException {
        this(new FileInputStream(file));
    }
    
    
    /**
     * Sets the input stream.
     * This implementation throws an exception when the stream is already set.
	 * @param in the stream to set
	 */
	public void setInputStream(InputStream in) {
    	if (inputStream != null) throw new IllegalStateException("InputStream already set");
    	inputStream = in;
    	open();
	}

    /**
     * Returns the underlying reader.
     * @return reader object
     */
    protected BufferedReader getReader() {
    	if (reader == null) reader = new BufferedReader(new InputStreamReader(getInputStream()));
    	return reader;
    }
    
    /**
     * Returns the underlying input stream.
	 * @return the inputStream
	 */
	public InputStream getInputStream() {
		return inputStream;
	}

    /**
     * Resets the reader and its underlying stream.
     */
    @Override
    public void reset() {
        try {
            if (getInputStream() != null) getInputStream().reset();
            if (reader != null) reader.reset();
        } catch (IOException e) {
            throw new IllegalStateException(e.toString(), e);
        }
    	super.reset();
    }
    
    /**
	 * This method throws an exception.
	 * Input streams cannot support the remove method.
	 */
	@Override
	public void remove() {
		throw new UnsupportedOperationException("Operation not supported for CSV streams");
	}

	/**
     * Closes the reader and its underlying stream.
     */
	@Override
    public void close() {
        try {
        	if (inputStream != null) inputStream.close();
            if (reader != null) reader.close();
        } catch (Exception e) {
            throw new IllegalStateException(e.toString());
        }
        super.close();
    }
    
}
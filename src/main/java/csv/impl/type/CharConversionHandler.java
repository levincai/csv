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
package csv.impl.type;

import csv.TypeConversionHandler;

/**
 * Conversion Handler for char.
 * @author ralph
 *
 */
public class CharConversionHandler implements TypeConversionHandler {

	public static final TypeConversionHandler INSTANCE = new CharConversionHandler();
	
	/**
	 * Constructor.
	 */
	public CharConversionHandler() {
	}

	/**
	 * @see csv.TypeConversionHandler#getTypes()
	 */
	@Override
	public String[] getTypes() {
		return new String[] { "char", "java.lang.Character" };
	}

	/**
	 * @see csv.TypeConversionHandler#toObject(java.lang.String)
	 */
	@Override
	public Object toObject(String s) {
		return s.charAt(0);
	}

	/**
	 * @see csv.TypeConversionHandler#toString(java.lang.Object)
	 */
	@Override
	public String toString(Object o) {
		return o.toString();
	}

}

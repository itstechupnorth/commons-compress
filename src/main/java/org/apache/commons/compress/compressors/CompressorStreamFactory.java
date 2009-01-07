/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.commons.compress.compressors;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;

/**
 * Factory to create Compressor[In|Out]putStreams from names
 * In order add other implementations you should extend CompressorStreamFactory
 * and override the appropriate methods (and call their implementation
 * from super of course)
 * 
 * TODO add example here 
 * 
 */
public class CompressorStreamFactory {

	public CompressorInputStream createCompressorInputStream( final String name, final InputStream in ) throws CompressorException {
		try {

			if("gz".equalsIgnoreCase(name)) {
				return new GzipCompressorInputStream(in);
			} else if("bzip2".equalsIgnoreCase(name)) {
				return new BZip2CompressorInputStream(in);
			} 

			return null;
		
		} catch (IOException e) {
			throw new CompressorException("Could not create CompressorInputStream", e);
		}
    }

    public CompressorOutputStream createCompressorOutputStream( final String name, final OutputStream out ) throws CompressorException {
		try {

			if("gz".equalsIgnoreCase(name)) {
					return new GzipCompressorOutputStream(out);
			} else if("bzip2".equalsIgnoreCase(name)) {
					return new BZip2CompressorOutputStream(out);
			} 
			return null;

		} catch (IOException e) {
			throw new CompressorException("Could not create CompressorOutputStream", e);
		}
    }
}
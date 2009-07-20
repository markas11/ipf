/*
 * Copyright 2009 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openehealth.ipf.platform.camel.cda.extend

import org.apache.camel.builder.DataFormatClause
import org.openehealth.ipf.platform.camel.cda.dataformat.CDADataFormat
import org.openehealth.ipf.modules.cda.CDAR2Constants
/**
 * @author Christian Ohr
 */
public class CDAModelExtension{

     static extensions = { 

         // ----------------------------------------------------------------
         //  Adapter Extensions for DataFormatClause
         // ----------------------------------------------------------------
         
         DataFormatClause.metaClass.cdar2 = { ->
             CDADataFormat dataFormat = new CDADataFormat()
             delegate.dataFormat(dataFormat)
         }         
     
         // ----------------------------------------------------------------
         //  IPF model class extensions
         // ----------------------------------------------------------------
         
         // W3C Schema validation
         
         ValidatorAdapterType.metaClass.cdar2 = {-> 
             delegate.staticProfile(CDAR2Constants.CDAR2_SCHEMA)
         }

         // Schematron validation
         
         ValidatorAdapterType.metaClass.ccd = { Map parameters ->
             delegate.staticProfile(new SchematronProfile(CDAR2Constants.CCD_SCHEMATRON_RULES, parameters))
         }
         
         ValidatorAdapterType.metaClass.ccd = {-> 
             delegate.staticProfile(new SchematronProfile(CDAR2Constants.CCD_SCHEMATRON_RULES))
         }
     }
    
}
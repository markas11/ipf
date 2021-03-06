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
package org.openehealth.ipf.commons.xml;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openehealth.ipf.commons.xml.XsltTransmogrifier;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Christian Ohr
 */
public class XsltTransmogrifierTest {

    private XsltTransmogrifier<String> transformer;

    @Before
    public void setUp() throws Exception {
        transformer = new XsltTransmogrifier<String>(String.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testConvertString() throws IOException {
        Source source = new StreamSource(new ClassPathResource(
                "xslt/createPatient.xml").getInputStream());
        String result = transformer.zap(source,
                "xslt/createPatient.xslt");
        assertNotNull(result);
    }

}

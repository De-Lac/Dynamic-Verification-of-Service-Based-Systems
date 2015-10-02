/*
 * Copyright 2012 OW2 Consortium.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.unicam.choreos.registry.osgi;

import org.eclipse.core.runtime.adaptor.EclipseStarter;
import org.eclipse.osgi.framework.internal.core.Framework;
import org.eclipse.osgi.launch.EquinoxFactory;
import org.junit.*;
import static org.junit.Assert.*;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 *
 * @author midhat
 */
public class ActivatorTest {
    
    static BundleContext context;
    static Activator instance;
    public ActivatorTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
            EquinoxFactory equinoxFactory = new org.eclipse.osgi.launch.EquinoxFactory();
        org.osgi.framework.launch.Framework newFramework = equinoxFactory.newFramework(null);
        newFramework.start();
        context=newFramework.getBundleContext();
        instance = new Activator();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    
    @Before
    public void setUp() throws Exception {
    
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of start method, of class Activator.
     */
    @Test
    public void testStart() throws Exception {
   
           System.out.println("start");
        //   System.out.println(context==null);
        
        instance.start(context);
        
        
    }

    /**
     * Test of stop method, of class Activator.
     */
    @Test
    public void testStop() throws Exception {
        testStart();
        System.out.println("stop");
        instance.stop(context);
        // TODO review the generated test code and remove the default call to fail.
        
    }
}

/*******************************************************************************
 *  Copyright (c) 2012 VMware, Inc.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      VMware, Inc. - initial API and implementation
 *******************************************************************************/

package org.springframework.ide.eclipse.bestpractices.tests.ruletests;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.springframework.ide.eclipse.bestpractices.tests.AbstractBeansCoreTestCase;
import org.springframework.ide.eclipse.internal.bestpractices.springiderules.RefElementRule;


/**
 * Test case for the {@link RefElementRule} class.
 * @author Wesley Coelho
 * @author Leo Dos Santos
 * @author Terry Denney
 * @author Christian Dupuis
 * @author Steffen Pingel
 */
public class RefElementRuleTest extends AbstractBeansCoreTestCase {

	public void testMarkerCreated() throws Exception {
		IResource resource = createPredefinedProjectAndGetResource("bestpractices", "src/ref-element-positive.xml");
		IMarker[] markers = resource.findMarkers(null, false, IResource.DEPTH_ZERO);
		assertHasMarkerWithText(markers, RefElementRule.INFO_MESSAGE);
	}

	public void testMarkerNotCreated() throws Exception {
		IResource resource = createPredefinedProjectAndGetResource("bestpractices", "src/ref-element-negative.xml");
		IMarker[] markers = resource.findMarkers(null, false, IResource.DEPTH_ZERO);
		assertNotHasMarkerWithText(markers, RefElementRule.INFO_MESSAGE);
	}

}

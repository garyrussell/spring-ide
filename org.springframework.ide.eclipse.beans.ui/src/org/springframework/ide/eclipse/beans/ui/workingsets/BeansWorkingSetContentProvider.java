/*******************************************************************************
 * Copyright (c) 2005, 2007 Spring IDE Developers
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Spring IDE Developers - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.eclipse.beans.ui.workingsets;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.springframework.ide.eclipse.beans.core.model.IBeansConfigSet;
import org.springframework.ide.eclipse.beans.ui.navigator.BeansNavigatorContentProvider;
import org.springframework.ide.eclipse.core.model.IModelElement;

/**
 * Simple extension of the {@link BeansNavigatorContentProvider} that prevents
 * children for {@link IBeansConfigSet} and {@link IFile} instances.
 * @author Christian Dupuis
 * @since 2.0
 */
public class BeansWorkingSetContentProvider extends
		BeansNavigatorContentProvider implements ITreeContentProvider {

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IBeansConfigSet) {
			return IModelElement.NO_CHILDREN;
		}
		else if (parentElement instanceof IFile) {
			return IModelElement.NO_CHILDREN;
		}
		return super.getChildren(parentElement);
	}
}
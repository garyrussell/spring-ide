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
package org.springframework.ide.eclipse.beans.core.internal.model.validation.rules;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.ide.eclipse.beans.core.internal.model.BeansModelUtils;
import org.springframework.ide.eclipse.beans.core.model.IBean;
import org.springframework.ide.eclipse.beans.core.model.IBeansConfig;
import org.springframework.ide.eclipse.beans.core.model.IBeansConfigSet;
import org.springframework.ide.eclipse.core.model.IModelElement;

/**
 * Helpers for validation rules.
 * 
 * @author Torsten Juergeleit
 * @since 2.0
 */
public final class ValidationRuleUtils {

	private static final String PLACEHOLDER_PREFIX = "${";
	private static final String PLACEHOLDER_SUFFIX = "}";

	private static final String FACTORY_BEAN_REFERENCE_PREFIX = "&";

	/**
	 * Returns <code>true</code> if given text contains a placeholder, e.g.
	 * <code>${beansRef}</code>.
	 */
	public static boolean hasPlaceHolder(String text) {
		int pos = text.indexOf(PLACEHOLDER_PREFIX);
		return (pos != -1 && text.indexOf(PLACEHOLDER_SUFFIX, pos) != -1);
	}

	/**
	 * Returns <code>true</code> if the specified text is a reference to a
	 * factory bean, e.g. <code>&factoryBean</code>.
	 */
	public static boolean isFactoryBeanReference(String property) {
		return property.startsWith(FACTORY_BEAN_REFERENCE_PREFIX);
	}

	/**
	 * Returns the given {@link IBean bean}'s bean class name. For child beans
	 * the corresponding parents are resolved within the bean's
	 * {@link IBeansConfig} only.
	 */
	public static String getBeanClassName(IBean bean) {
		return getBeanClassName(bean, BeansModelUtils.getConfig(bean));
	}

	/**
	 * Returns the given {@link IBean bean}'s bean class name. For child beans
	 * the corresponding parents are resolved within the given context
	 * ({@link IBeansConfig} or {@link IBeansConfigSet}).
	 */
	public static String getBeanClassName(IBean bean, IModelElement context) {
		BeanDefinition bd = BeansModelUtils.getMergedBeanDefinition(bean,
				context);
		if (bd != null) {
			return bd.getBeanClassName();
		}
		return null;
	}
}
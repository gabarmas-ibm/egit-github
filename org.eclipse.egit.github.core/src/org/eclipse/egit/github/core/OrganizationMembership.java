/******************************************************************************
 *  Copyright (c) 2014, 2015 Arizona Board of Regents
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *    Michael Mathews (Arizona Board of Regents) - (Bug: 447419)
 *    			 Team Membership API implementation
 *****************************************************************************/
package org.eclipse.egit.github.core;

import java.io.Serializable;

/**
 * Team Membership model class.
 */
public class OrganizationMembership implements Serializable {

	private static final long serialVersionUID = -8207728181588115431L;


	private String url;

	private String state;

	private String role;

	private String organizationUrl;

	private User organization;

	private User user;

	public String getUrl() {
		return url;
	}

	public String getState() {
		return state;
	}

	public String getRole() {
		return role;
	}

	public String getOrganizationUrl() {
		return organizationUrl;
	}

	public User getOrganization() {
		return organization;
	}

	public User getUser() {
		return user;
	}

}

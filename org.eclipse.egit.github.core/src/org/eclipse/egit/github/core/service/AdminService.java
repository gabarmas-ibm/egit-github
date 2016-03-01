/******************************************************************************
 *  Copyright (c) 2016 IBM Corp.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *    Gabriel Lopez de Armas (IBM Corp.) - Extend for GitHub Enterprise API
 *****************************************************************************/
package org.eclipse.egit.github.core.service;

import static org.eclipse.egit.github.core.client.IGitHubConstants.SEGMENT_ADMIN;
import static org.eclipse.egit.github.core.client.IGitHubConstants.SEGMENT_AUTHORIZATIONS;
import static org.eclipse.egit.github.core.client.IGitHubConstants.SEGMENT_USERS;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.eclipse.egit.github.core.Authorization;
import org.eclipse.egit.github.core.client.GitHubClient;

/**GitHub Enterprise only:
 * User Administration service class
 *
 * @see <a href="https://developer.github.com/enterprise/2.4/v3/users/administration/">GitHub Enterprise User
 *      documentation</a>
 */
public class AdminService extends GitHubService {

	/**
	 * Create Enterprise service
	 */
	public AdminService() {
		super();
	}

	/**
	 * Create Enterprise  service
	 *
	 * @param client
	 */
	public AdminService(GitHubClient client) {
		super(client);
	}


	/**
	 * Create or refresh impersonation token for a given user
	 *
	 * @param user User login to impersonate
	 * @return authorization
	 * @throws IOException
	 */
	public Authorization createImpersonationToken(String user, Collection<String> scopes) throws IOException {
		StringBuilder uri = new StringBuilder(SEGMENT_ADMIN);
		uri.append(SEGMENT_USERS).append('/').append(user).append(SEGMENT_AUTHORIZATIONS);
		Map<String, Collection<String>> params = Collections.singletonMap(
				"scopes", scopes); //$NON-NLS-1$
		return (Authorization) client.post(uri.toString(), params, Authorization.class);
	}

	/**
	 * Create or refresh impersonation token for a given user
	 *
	 * @param id
	 * @return authorization
	 * @throws IOException
	 */
	public void deleteImpersonationToken(String user) throws IOException {
		StringBuilder uri = new StringBuilder(SEGMENT_ADMIN);
		uri.append(SEGMENT_USERS).append('/').append(user).append(SEGMENT_AUTHORIZATIONS);
		client.delete(uri.toString());
	}


}
